package Tutor_Source_Code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A class to manage a database of user accounts stored in a JSON file.
 */
public class AccountDB {
	private List<Account> accounts;
	private String file;

	/**
	 * Constructs an AccountDB instance with the given JSON file.
	 *
	 * @param file The name of the JSON file to load and save accounts.
	 */
	public AccountDB(String file) {
		this.file = file;
		accounts = loadAccounts();
	}

	/**
	 * Load accounts from a JSON file.
	 *
	 * @return A list of loaded accounts.
	 */
	private List<Account> loadAccounts() {
		List<Account> loadedAccounts = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			Gson gson = new Gson();
			Account[] accountArray = gson.fromJson(reader, Account[].class);
			if (accountArray != null) {
				loadedAccounts = new ArrayList<>(List.of(accountArray));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loadedAccounts;
	}

	/**
	 * Save accounts to a JSON file.
	 */
	private void saveAccounts() {
		try (FileWriter writer = new FileWriter(file)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(accounts.toArray(new Account[0]));
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add a new account to the database.
	 *
	 * @param email    The email address of the new account.
	 * @param password The password of the new account.
	 * @param name     The name associated with the new account.
	 * @param isTutor  Indicates if the new account is a tutor or not.
	 */
	public void addAccount(String email, String password, String name, Boolean isTutor) {
		if (!isEmailTaken(email)) {
			Account account = new Account(email, password, name, isTutor);
			accounts.add(account);
			saveAccounts();
		}
	}

	/**
	 * Update an existing account's information.
	 *
	 * @param accountId   The unique ID of the account to update.
	 * @param newEmail    The updated email for the account.
	 * @param newPassword The updated password for the account.
	 * @param newName     The updated name for the account.
	 * @return true if the account was successfully updated, false if the account
	 *         was not found.
	 */
	public boolean updateAccount(UUID accountId, String newEmail, String newPassword, String newName) {
		Account accountToUpdate = getAccountById(accountId.toString());
		if (accountToUpdate != null) {
			// Update the account information.
			accountToUpdate.setEmail(newEmail);
			accountToUpdate.setPassword(newPassword);
			accountToUpdate.setName(newName);

			saveAccounts(); // Save the updated account data to the JSON file.
			return true; // Account successfully updated.
		}
		return false; // Account not found, update failed.
	}

	/**
	 * Remove an account from the database by its unique ID.
	 *
	 * @param accountId The unique ID of the account to be removed.
	 */
	public void removeAccount(UUID accountId) {
		accounts.removeIf(account -> account.getID().equals(accountId));
		saveAccounts();
	}

	/**
	 * Check if a given email and password combination is valid.
	 *
	 * @param email    The email to be checked.
	 * @param password The password to be checked.
	 * @return True if the combination is valid, false otherwise.
	 */
	public boolean isLoginValid(String email, String password) {
		return accounts.stream()
				.anyMatch(account -> account.getEmail().equals(email) && account.getPassword().equals(password));
	}

	/**
	 * Check if a given email is already taken by an existing account.
	 *
	 * @param email The email to be checked.
	 * @return True if the email is already taken, false otherwise.
	 */
	public boolean isEmailTaken(String email) {
		return accounts.stream().anyMatch(account -> account.getEmail().equals(email));
	}

	/**
	 * Get an account based on the given email address.
	 *
	 * @param email The email address to search for.
	 * @return The Account object associated with the given email, or null if not
	 *         found.
	 */
	public Account getAccountByEmail(String email) {
		return accounts.stream().filter(account -> account.getEmail().equals(email)).findFirst().orElse(null);
	}

	/**
	 * Get an account by its unique ID.
	 *
	 * @param accountId The unique ID of the account to retrieve.
	 * @return The Account object associated with the given ID, or null if not
	 *         found.
	 */
	public Account getAccountById(String accountId) {
		return accounts.stream().filter(account -> account.getID().toString().equals(accountId)).findFirst()
				.orElse(null);
	}

}
