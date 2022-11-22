import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
A class representing two integers
 */
public class Data extends  Thread
{
    private int x = 0;
    private int y = 0;
    // A variable used to execute that a thread has made an update and is waiting for it
    boolean inUse = false;
    // A variable that holds the number of the thread that performed the update
    int currentNum = -1;
    // A variable updates how many updates to get the differences have been made
    int finished = 0;
    // A lock to prevent parallel execution of updating and getting the data
    Lock lock = new ReentrantLock();
    // A Boolean variable describing whether an update is in progress
    boolean updating = false;
    // A Boolean variable describing whether get the difference is performed
    boolean gettingDiff = false;


    /*
    A constructor that initializes both class numbers
     */
    public Data (int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /*
    Using the lock and the boolean variable updating help us that
     */
    public int getDiff()
    {
        try{
            if (updating = true)
            {
                lock.lock();
                try {
                    gettingDiff = true;
                    return Math.abs(x - y);
                }
                finally {
                    lock.unlock();
                }
            }
            lock.unlock();
            return Math.abs(x - y);
        }
        finally {
            gettingDiff = false;
            notifyAll();
        }

    }

    /*
    While using gettingDiff method the object will wait while trying to update.
    notifyAll function will activate just after getDiff finish
     */
    public synchronized void update(int dx, int dy)
    {
        while(gettingDiff)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.lock();
        updating = true;
        try
        {
            x = x + dx;
            y = y + dy;
            System.out.println("["+this.x + "," + this.y + "]");
        }
        finally {
            lock.unlock();
            updating = false;
        }

    }

    /*
     A method that synchronizes thread operations according to the data update and fetching by the appropriate thread while the program is running
     */
    public synchronized void synchronizedMethod(String act, int num) throws InterruptedException
    {
        /*
        While it's not the right number or update - waiting for calculate
         */
        while (  !  (  (!inUse && act.equals("update")) || (currentNum == num && act.equals("calculate"))   )     )
        {
            System.out.println("I'm Thread number: " + num + "\tMy act is: " + act + ".\tIt's not my turn yet so I'll go into wait mode\n");
            wait();
            System.out.println("I'm Thread number: " + num + "\tMy act is:" + act + ".\tIt might be my turn so I'll come out of wait mode");
        }

        /*
        We will perform an update only if the accessed thread is of the update type
         */
        if (act.equals("update"))
        {
            System.out.println("I'm Thread number: " + num + "\tMy act is: " + act + ".\tIt's my turn so I update");

            update(generateNumber(), generateNumber());
            inUse = true;
            currentNum = num;
            notifyAll();
        }
        /*
        If it's not an update type act then it's a get the difference act type
         */
        else
        {
            System.out.println("I'm Thread number: " + num + "\tMy act is: " + act + ".\tIt's my turn so I calculate");
            System.out.println("The difference is: " + getDiff());
            notifyAll();
            inUse = false;
            currentNum = -1;
            finished++;
            System.out.println("Finished: " + finished + "\n\n");
        }
    }

    /*
    Generate a random number between 1 and 10
     */
    private int generateNumber()
    {
        final int MAX_VALUE = 10;
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE) + 1;
    }
}
