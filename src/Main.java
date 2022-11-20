import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Data d = new Data(0,0);
        Thread Generator = new Thread(new Data(0,0));
        CalculatorThread c = new CalculatorThread(d);

        g.start();
        c.start();
    }

}
