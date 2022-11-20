import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int NUMBER_OF_DATA = 10;
        ArrayList<Data> DataArray = new ArrayList<Data>();

        for (int i = 0 ; i < NUMBER_OF_DATA ; i ++)
        {
            DataArray.add(new Data(generateInteger(), generateInteger()));
        }
    }

    private static int generateInteger()
    {
        final int MAX = 10;

        Random rand = new Random();
        return rand.nextInt(MAX);
    }
}
