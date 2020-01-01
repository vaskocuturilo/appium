package utils;

import com.sun.istack.internal.NotNull;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * The class Phone.
 */
public final class Phone {

    /**
     * The private constructor.
     */
    private Phone() {
    }

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
     * The method createPhoneNumber.
     *
     * @return the string
     */
    @NotNull
    public static String createPhoneNumber() {
        Random rand = new Random();
        int firstNumber = rand.nextInt(FIRST_NUMBER);
        int secondNumber = rand.nextInt(SECOND_NUMBER);

        DecimalFormat decimalFormatThreeElements = new DecimalFormat("000");
        DecimalFormat decimalFormatFourElements = new DecimalFormat("0000");

        String phoneNumber = decimalFormatThreeElements.format(TEL_CODE) + "-" + decimalFormatThreeElements.format(firstNumber) + "-" + decimalFormatFourElements.format(secondNumber);

        return phoneNumber;
    }
}
