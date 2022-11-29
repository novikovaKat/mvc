package character;

import java.util.Arrays;
import java.util.Random;

public class Dice {
    private final static int THROWING = 6;
    private final static int SELECTION = 3;
    private int roll(){
        Random random = new Random();

        return random.nextInt(6) + 1;
    }
    public int rollStat(){
        int [] values = new int[THROWING];

        for (int i = 0; i < THROWING; i++) {
            values[i] = roll();
        }

        Arrays.sort(values);
       // System.out.println(Arrays.toString(values));

        int sum = 0;
        for (int i = THROWING - SELECTION; i < THROWING; i++) {
            sum+=values[i];
        }
        return sum;
    }
}
