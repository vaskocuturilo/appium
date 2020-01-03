package data;

/**
 * The class RegisterUserData.
 */
public class RegisterUserData {

    /**
     * The private value firstName.
     */
    private String firstName;

    /**
     * The private value middleName.
     */
    private String middleName;

    /**
     * The private value lastName.
     */
    private String lastName;

    /**
     * The private value birthDate.
     */
    private String birthDate;

    /**
     * The private value email.
     */
    private String email;

    /**
     * The constructor.
     *
     * @param userFirstName  the first name
     * @param userMiddleName the middle name
     * @param userLastName   the last name
     * @param userBirthDate  the birth date
     * @param userEmail      the email
     */
    public RegisterUserData(final String userFirstName, final String userMiddleName, final String userLastName, final String userBirthDate, final String userEmail) {
        this.firstName = userFirstName;
        this.middleName = userMiddleName;
        this.lastName = userLastName;
        this.birthDate = userBirthDate;
        this.email = userEmail;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets middle name.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }
}
