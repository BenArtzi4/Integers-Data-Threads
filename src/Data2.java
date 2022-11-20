import java.util.Random;

public class Data2 extends  Thread
{
    private int x = 0;
    private int y = 0;


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

    public synchronized void synchronizedMethod(String act)
    {
        if (act.equals("generate"))
        {
            update(generateNumber(), generateNumber());
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (act.equals("calculate"))
        {
            System.out.println("Difference is: " + getDiff());
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int generateNumber()
    {
        final int MAX_VALUE = 10;
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE);
    }
}
