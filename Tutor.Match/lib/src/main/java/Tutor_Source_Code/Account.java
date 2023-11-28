package Tutor_Source_Code;

import java.util.UUID;

/**
 * The Account class represents a user account with email, password, and name.
 */
public class Account implements Comparable<Account> {
	private UUID id;
	private String email;
	private String password;
	private String name;
	private boolean tutor;
	private Schedule schedule;

	/**
	 * Constructs a new Account for a TUTOR STUDENT with the given email, password,
	 * and name.
	 *
	 * @param email    The email associated with the account.
	 * @param password The password for the account.
	 * @param name     The name of the account holder.
	 */
	public Account(String email, String password, String name, boolean tutor) {
		this.id = UUID.randomUUID();
		this.email = email;
		this.password = password;
		this.name = name;
		this.tutor = tutor;
		this.schedule = new Schedule();
	}

	/*
	 * Loading accounts from '.students.txt' file
	 */
	public Account(String email, String password, String name, boolean tutor, UUID id, int studyTime) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.tutor = tutor;
	}

	/**
	 * Gets the email associated with the account.
	 *
	 * @return The email of the account.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Gets the password of the account.
	 *
	 * @return The password of the account.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Validates password
	 * 
	 * @param password - password to be validated
	 * @return - boolean value relative to the parameter password being equal to
	 *         this.password
	 */
	public boolean passIsValid(String password) {
		return this.password.equals(password);
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

	/**
	 * Gets tutor value
	 * 
	 * @return tutor boolean; used for permission access
	 */
	public boolean getTutor() {
		return tutor;
	}

	/*
	 * Give student tutor privileges
	 */
	public void isTutor() {
		this.tutor = true;
	}

	/*
	 * Revoke student tutor privileges
	 */
	public void notTutor() {
		this.tutor = false;
	}

	/*
	 * Returns user ID
	 */
	public UUID getID() {
		return this.id;
	}

	/**
	 * Compares this.Account to argument object - returns boolean value relative to
	 * equality
	 */
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Account) {
			Account temp = (Account) obj;
			return this.id == temp.id;
		}
		return false;
	}

	/**
	 * Checks if this.email is equal to the email argument - Returns boolean value
	 * relative to equality - This is the function used by the "collections.sort"
	 * framework - Accounts are sorted by email
	 */
	public int compareTo(Account acc) {
		return this.email.compareTo(acc.email);
	}

	/**
	 * Returns this.Account as a formatted string
	 */
	public String toString() {
		return String.format("%s%n%s%n%s%n%s%n%s%n", this.email, this.password, this.name, this.tutor, this.id);
	}

	/**
	 * Get the schedule associated with this object.
	 *
	 * @return The schedule associated with this object.
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	/**
	 * Set a new schedule for this object.
	 *
	 * @param newSchedule The new schedule to be associated with this object.
	 */
	public void setSchedule(Schedule newSchedule) {
		this.schedule = newSchedule;
	}
	
	
	/**
	 * Returns String of public tutor info that is displayed to students
	 * @return
	 */
	public String toStringTutor() {
		return String.format("Name: %s Email: %s", this.name, this.email);
	}
}
