package Backend;
import java.util.UUID;

/**
 * The Account class represents a user account with email, password, and name.
 */
@SuppressWarnings("unused")
public class Account implements Comparable<Account>
{
    private int id;
    private String email;
    private String password;
    private String name;
	private boolean tutor;
    private static int count = 1;
    private int studyTime;

    /**
     * Constructs a new Account for a NON-TUTOR STUDENT with the given email, password, and name.
     *
     * @param email    The email associated with the account.
     * @param password The password for the account.
     * @param name     The name of the account holder.
     */
    public Account(String email, String password, String name) 
    {
    	this.id = count;
        this.email = email;
        this.password = password;
        this.name = name;
        this.studyTime = 0;
        this.tutor = false;
        count++;
    }

    /**
     * Constructs a new Account for a TUTOR STUDENT with the given email, password, and name.
     *
     * @param email    The email associated with the account.
     * @param password The password for the account.
     * @param name     The name of the account holder.
     */
    public Account(String email, String password, String name, boolean tutor) 
    {
    	this.id = count;
        this.email = email;
        this.password = password;
        this.name = name;
        this.studyTime = 0;
        this.tutor = tutor;
        count++;
    }
    
    /*
     * Loading accounts from '.students.txt' file
     */
    public Account(String email, String password, String name, boolean tutor, int id, int studyTime)
    {
    	this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.studyTime = studyTime;
        this.tutor = tutor;
    }

    /**
     * Gets the email associated with the account.
     *
     * @return The email of the account.
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * Gets the password of the account.
     *
     * @return The password of the account.
     */
    public String getPassword() 
    {
        return password;
    }

    /**
     * Gets the name of the account holder.
     *
     * @return The name of the account holder.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Sets a new email for the account.
     *
     * @param newEmail The new email to set.
     */
    public void setEmail(String newEmail) 
    {
        this.email = newEmail;
    }

    /**
     * Sets a new name for the account holder.
     *
     * @param newName The new name to set.
     */
    public void setName(String newName) 
    {
        this.name = newName;
    }

    /**
     * Sets a new password for the account.
     *
     * @param newPassword The new password to set.
     */
    public void setPassword(String newPassword) 
    {
        this.password = newPassword;
    }
    
    /*
     * Returns tutor status to validate permissions
     */
    public boolean getTutor()
    {
    	return tutor;
    }
    
    /*
     * Give student tutor privileges
     */
    public void isTutor()
    {
    	this.tutor = true;
    }
    
    /*
     * Revoke student tutor privileges
     */
    public void notTutor()
    {
    	this.tutor = false;
    }
    
    /*
     * Returns user ID
     */
    public int getID()
    {
    	return this.id;
    }
    
    /*
     * Returns total tutor time
     */
    public int getTime()
    {
    	return this.studyTime;
    }
    
    /*
     * Returns total number of users in database
     */
    public static int getCount()
    {
    	return count;
    }
    
    /**
     * Compares Account objects
     */
    public boolean equals(Object obj)
    {
    	if(obj != null && obj instanceof Account)
    	{
    		Account temp = (Account) obj;
    		return this.id == temp.id;
    	}
    	return false;
    }

    /*
     * Compares this.email to passed email
     * This is the function used by the "collections.sort" framework
     */
    public int compareTo(Account acc) 
    {
    	return email.compareTo(acc.email);
    }
    
    /*
     * Formats this.Account into a string
     */
    public String toString()
    {
    	return String.format("%s%n%s%n%s%n%s%n%d%n%d",
    			this.email, this.password, this.name, this.tutor, this.id, this.studyTime);
    }
}

