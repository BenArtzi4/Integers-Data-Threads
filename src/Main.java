import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Data data = new Data(0,0);
        GeneratorThread generator = new GeneratorThread(data);
        CalculatorThread calculator = new CalculatorThread(data);

        generator.start();
        calculator.start();


        /*
        Data2 data2 = new Data2(0,0);
        GeneratorThread2 generator2 = new GeneratorThread2(data2);
        CalculatorThread2 calculator2 = new CalculatorThread2(data2);

        generator2.start();
        calculator2.start();
        */

    }
}
