package Backend;
import java.util.UUID;

/**
 * The Account class represents a user account with email, password, and name.
 */
public class Account {
    private UUID userId;
    private String email;
    private String password;
    private String name;

    /**
     * Constructs a new Account with the given email, password, and name.
     *
     * @param email    The email associated with the account.
     * @param password The password for the account.
     * @param name     The name of the account holder.
     */
    public Account(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        userId = UUID.randomUUID();
    }

    /**
     * Gets the unique identifier (UUID) of the account.
     *
     * @return The UUID of the account.
     */
    public UUID getID() {
        return userId;
    }

    /**
     * Gets the email associated with the account.
     *
     * @return The email of the account.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the password of the account.
     *
     * @return The password of the account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the name of the account holder.
     *
     * @return The name of the account holder.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new email for the account.
     *
     * @param newEmail The new email to set.
     */
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    /**
     * Sets a new name for the account holder.
     *
     * @param newName The new name to set.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Sets a new password for the account.
     *
     * @param newPassword The new password to set.
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}

