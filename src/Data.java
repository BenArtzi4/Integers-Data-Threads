public class Data
{
    private int x = 0;
    private int y = 0;
    boolean isGenerator;


    public Data (int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getDiff()
    {
        return (Math.abs(x - y));
    }
    public synchronized void update(int dx, int dy)
    {
        isGenerator = true;
        x = x + dx;
        y = y + dy;
    }

    @Override
    public String toString()
    {
        return "["+this.x + "," + this.y + "]";
    }
}
