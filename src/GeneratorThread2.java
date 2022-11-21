import java.util.Random;

public class GeneratorThread2 extends Thread {
    Data2 data;
    String act = "generate";
    int num;
    final int RUNNING_TIMES = 10;
    final int MAX_VALUE = 10;

    public GeneratorThread2(Data2 data, int num) throws InterruptedException {
        this.data = data;
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0 ; i < RUNNING_TIMES ; i++)
        {
            try {
                data.synchronizedMethod(act,num);
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
