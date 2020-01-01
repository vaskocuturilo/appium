package environment;

/**
 * The class Environment.
 */
public final class Environment {

    /**
     * The private constructor.
     */
    private Environment() {
    }

    /**
     * Method isCheckOperatingSystem.
     * If method return true, that is automation scripts to run on OS Unix or Linux.
     * If method return false, that is automation scripts to run on OS Windows or Mac.
     *
     * @return the boolean.
     */
    public static boolean isCheckOperationSystem() {
        String operationSystem = System.getProperty("os.name");
        return ("win".contains(operationSystem) || ("dows").contains(operationSystem));
    }
}
