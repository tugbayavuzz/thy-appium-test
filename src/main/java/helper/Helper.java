package helper;

import java.util.Random;

public class Helper {
    public static int randomNumber(int start, int end) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(end - 1) + start;
        return randomNumber;
    }


}
