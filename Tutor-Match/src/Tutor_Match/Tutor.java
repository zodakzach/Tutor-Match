package Tutor_Match;

/**
 * The Tutor class represents a tutor user account.
 * It inherits from the Account class.
 */
public class Tutor extends Account {

    /**
     * Constructs a new Tutor account with the given email, password, and name.
     *
     * @param email    The email associated with the tutor account.
     * @param password The password for the tutor account.
     * @param name     The name of the tutor.
     */
    public Tutor(String email, String password, String name) {
        super(email, password, name);
    }
}
