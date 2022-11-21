import java.util.Random;

public class Data2 extends  Thread
{
    private int x = 0;
    private int y = 0;
    boolean inUse = false;
    boolean updated = false;
    int currentNum = -1;



    public Data2 (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getDiff()
    {
        return Math.abs(x - y);
    }
    public synchronized void update(int dx, int dy)
    {
        x = x + dx;
        y = y + dy;
        System.out.println("["+this.x + "," + this.y + "]");
    }

    public synchronized void synchronizedMethod(String act, int num) throws InterruptedException {


        /*
        While it's not the right number and
         */
        while (  !  (  (!inUse && act.equals("generate")) || (currentNum == num && act.equals("calculate"))   )     )
        {
            wait();
        }

        //System.out.println("Act: " + act +"\tNum: " + num +"\tInUse: " + inUse + "\tUpdated:" + updated + "\tCurrentNum: " + currentNum);


        if (act.equals("generate"))
        {

            System.out.println("Thread number: " + num);

            update(generateNumber(), generateNumber());
            notifyAll();
            inUse = true;
            updated = true;
            currentNum = num;
        }
        else
        {
            System.out.println("Difference is: " + getDiff());
            inUse = false;
            notifyAll();
            updated = false;
        }

    }

    private int generateNumber()
    {
        final int MAX_VALUE = 10;
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE);
    }
}
