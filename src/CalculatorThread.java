
public class CalculatorThread extends Thread
{
    Data data;
    String act = "calculate";
    int num;

    final int RUNNING_TIMES = 10;

    public CalculatorThread(Data data, int num)
    {
        this.data = data;
        this.num = num;
    }

    @Override
    public void run()
    {
        super.run();
        for (int i = 0 ; i < RUNNING_TIMES ; i++)
        {
            try {
                data.synchronizedMethod(act, num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
