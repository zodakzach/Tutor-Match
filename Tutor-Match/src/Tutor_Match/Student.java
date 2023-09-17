package Tutor_Match;

/**
 * The Student class represents a student user account.
 * It inherits from the Account class.
 */
public class Student extends Account {

    /**
     * Constructs a new Student account with the given email, password, and name.
     *
     * @param email    The email associated with the student account.
     * @param password The password for the student account.
     * @param name     The name of the student.
     */
    public Student(String email, String password, String name) {
        super(email, password, name);
    }
}
