import java.util.Random;

public class GeneratorThread2 extends Thread {
    Data2 data;
    String act = "generate";
    final int RUNNING_TIMES = 10;
    final int MAX_VALUE = 10;

    public GeneratorThread2(Data2 data) throws InterruptedException {
        this.data = data;
    }

    @Override
    public void run() {
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
