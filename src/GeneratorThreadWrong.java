import java.util.Random;

public class GeneratorThreadWrong extends Thread
{
    Data data;
    String act = "generate";
    final int RUNNING_TIMES = 10;
    final int MAX_VALUE = 10;

    public GeneratorThreadWrong(Data data) throws InterruptedException {
        this.data = data;
    }

    @Override
    public void run()
    {
        super.run();

        for (int i = 0 ; i < RUNNING_TIMES ; i++)
        {
            data.update(generateNumber(), generateNumber());
        }

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private int generateNumber()
    {
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE);
    }
}
