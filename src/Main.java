import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*
        Data data = new Data(0,0);
        GeneratorThread generator = new GeneratorThread(data);
        CalculatorThread calculator = new CalculatorThread(data);

        generator.start();
        calculator.start();

         */


        Data2 data2 = new Data2(0,0);
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0 ; i < 4 ; i ++)
        {
            threads.add(new GeneratorThread2(data2, i));
            threads.add(new CalculatorThread2(data2, i));

        }


        for (int i = 0 ; i < 8 ; i ++)
        {
            threads.get(i).start();
        }
    }
}
