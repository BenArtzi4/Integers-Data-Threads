public class Data extends  Thread
{
    private int x = 0;
    private int y = 0;
    boolean isGenerator;



    public Data (int x, int y){
        this.x = x;
        this.y = y;
        isGenerator = true;
    }
    public synchronized void getDiff(){
        if (isGenerator)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isGenerator = true;
        notify();
        System.out.println("Difference is: " + Math.abs(x - y) );
    }
    public synchronized void update(int dx, int dy)
    {
        if (!(isGenerator))
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        x = x + dx;
        y = y + dy;
        System.out.println("["+this.x + "," + this.y + "]");
        isGenerator = false;
        notify();
    }
}
