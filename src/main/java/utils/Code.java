package utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * The class Code.
 */
public final class Code {

    /**
     * The private value NUMBER.
     */
    private static final int NUMBER = 10000;

    /**
     * The private constructor.
     */
    private Code() {
    }

    /**
     * The method createCode.
     *
     * @return the string
     */
    public static String createCode() {
        final Random rand = new Random();
        final int number = rand.nextInt(NUMBER);
        final DecimalFormat decimalFormat = new DecimalFormat("0000");
        final String code = decimalFormat.format(number);

        return code;
    }
}
