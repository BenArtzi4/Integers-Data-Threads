import java.util.Random;

public class Data extends  Thread
{
    private int x = 0;
    private int y = 0;
    boolean inUse = false;
    int currentNum = -1;
    int finished = 0;



    public Data (int x, int y){
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

    public synchronized void synchronizedMethod(String act, int num) throws InterruptedException
    {
        /*
        While it's not the right number or generate waiting for calculate
         */
        while (  !  (  (!inUse && act.equals("generate")) || (currentNum == num && act.equals("calculate"))   )     )
        {
            wait();
        }

        if (act.equals("generate"))
        {
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
            System.out.println("Finished: " + finished + "\n");
        }


    }

    private int generateNumber()
    {
        final int MAX_VALUE = 10;
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE);
    }
}
