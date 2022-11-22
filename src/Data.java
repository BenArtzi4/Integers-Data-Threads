import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data extends  Thread
{
    private int x = 0;
    private int y = 0;
    boolean inUse = false;
    int currentNum = -1;
    int finished = 0;
    Lock lock = new ReentrantLock();
    boolean updating = false;
    boolean gettingDiff = false;



    public Data (int x, int y){
        this.x = x;
        this.y = y;
    }

    /*
    Using the lock and the boolean cariable updating help us that
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

    public synchronized void synchronizedMethod(String act, int num) throws InterruptedException
    {
        /*
        While it's not the right number or generate waiting for calculate
         */
        while (  !  (  (!inUse && act.equals("generate")) || (currentNum == num && act.equals("calculate"))   )     )
        {
            System.out.println("I'm Thread number: " + num + "\tMy act is:" + act + "It's not my turn yet so I'll go into wait mode\n");
            wait();
            System.out.println("I'm Thread number: " + num + "\tMy act is:" + act + "It might be my turn so I'll come out of wait mode\n");

        }

        if (act.equals("generate"))
        {
            System.out.println("I'm Thread number: " + num + "\tMy act is:" + act + "It's my turn so I update");

            update(generateNumber(), generateNumber());
            inUse = true;
            currentNum = num;
            notifyAll();
        }
        else
        {
            System.out.println("The difference is: " + getDiff());
            notifyAll();
            inUse = false;
            currentNum = -1;
            finished++;
            System.out.println("Finished: " + finished);
            System.out.println("I'm Thread number: " + num + "\tMy act is:" + act + "It's my turn so I calculate\n\n");

        }


    }

    private int generateNumber()
    {
        final int MAX_VALUE = 10;
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE);
    }
}
