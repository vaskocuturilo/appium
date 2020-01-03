package utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * The class Phone.
 */
public final class Phone {
    /**
     * The constant FIRST_NUMBER.
     */
    private static final int FIRST_NUMBER = 743;

    /**
     * The constant SECOND_NUMBER.
     */
    private static final int SECOND_NUMBER = 10000;

    /**
     * The constant TEL_CODE.
     */
    private static final int TEL_CODE = 999;

    /**
     * The private constructor.
     */
    private Phone() {
    }

    /**
     * The method createPhoneNumber.
     *
     * @return the string
     */

    public static String createPhoneNumber() {
        final Random rand = new Random();
        final int firstNumber = rand.nextInt(FIRST_NUMBER);
        final int secondNumber = rand.nextInt(SECOND_NUMBER);

        final DecimalFormat decimalFormatThreeElements = new DecimalFormat("000");
        final DecimalFormat decimalFormatFourElements = new DecimalFormat("0000");

        final String phoneNumber = decimalFormatThreeElements.format(TEL_CODE) + "-" + decimalFormatThreeElements.format(firstNumber) + "-" + decimalFormatFourElements.format(secondNumber);

        return phoneNumber;
    }
}
