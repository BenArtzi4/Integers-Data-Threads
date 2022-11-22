import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Creating an object of type data and initializing it
        Data data = new Data(0,0);

        // Creating an arraylist of threads
        ArrayList<Thread> threads = new ArrayList<Thread>();

        // Initialization of the required threads
        for (int i = 0 ; i < 4 ; i ++)
        {
            threads.add(new GeneratorThread(data, i));
            threads.add(new CalculatorThread(data, i));
        }

        // Start of the required threads
        for (int i = 0 ; i < 8 ; i ++)
        {
            threads.get(i).start();
        }
    }
}
