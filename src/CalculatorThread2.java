
public class CalculatorThread2 extends Thread
{
    Data2 data;
    String act = "calculate";

    final int RUNNING_TIMES = 10;

    public CalculatorThread2(Data2 data)
    {
        this.data = data;
    }

    @Override
    public void run()
    {
        super.run();
        for (int i = 0 ; i < RUNNING_TIMES ; i++)
        {
            data.synchronizedMethod(act);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
