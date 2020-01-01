package utils;

import com.sun.istack.internal.NotNull;

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
    @NotNull
    public static String createCode() {
        Random rand = new Random();
        int number = rand.nextInt(NUMBER);
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        String code = decimalFormat.format(number);

        return code;
    }
}
