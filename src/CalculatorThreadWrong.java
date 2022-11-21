
public class CalculatorThreadWrong extends Thread
{
    Data data;
    String act = "calculate";

    final int RUNNING_TIMES = 10;

    public CalculatorThreadWrong(Data data)
    {
        this.data = data;
    }

    @Override
    public void run()
    {
        super.run();

        for (int i = 0 ; i < RUNNING_TIMES ; i++)
        {
            data.getDiff();
        }

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
