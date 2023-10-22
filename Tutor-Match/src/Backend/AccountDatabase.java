package Backend;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.UUID;


@SuppressWarnings("unused")
public class AccountDatabase 
{
	private static ArrayList<Account> database; // Account Database
	private static final int ACCOUNT_SIZE = 6; // Number of text lines in studentDB.txt file
	private String file;  // filename
	
	public AccountDatabase(String file)
	{
		database = new ArrayList<Account>();

		this.file = file;
		this.load();
	}
	
/**
* Loads the file into an ArrayList of Accounts
* @param file - Name of file to be uploaded
*/
	public void load()
	{
		var line = new String[ACCOUNT_SIZE];
		Scanner reader = null;
		Account temp = null;
		
		try
		{
			reader = new Scanner(new File(this.file));
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		while(reader.hasNextLine())
		{
			for(int x = 0; x < ACCOUNT_SIZE; x++)
			{
				line[x] = reader.nextLine();
			}
			
			temp = new Account(line[0], line[1], line[2], 
					Boolean.parseBoolean(line[3]), UUID.fromString(line[4]), Integer.parseInt(line[5]));
			
			database.add(temp);
			
			if(reader.hasNextLine())
			{
				reader.nextLine();
			}
		}
		
		reader.close();
	}
	
/**
* Displays database
*/	
	public void display()
	{
		System.out.println();
		
		for(int x = 0; x < database.size(); x++)
		{
			System.out.print(database.get(x).toString());
			
			if(x != database.size() - 1)
			{
				System.out.print("\n\n");
			}
		}
	}

/**
 * Searches database by email
 * - if match found, returns Account object
 * - returns null if no match found
 */
	public Account searchEmail(String email)
	{
		for(Account student:database)
		{
			if((student.getEmail().equals(email)))
			{
				return student;
			}
		}
		return null;
	}
	
/**
* Searches database by id
* - if match found, returns Account object
* - returns null if no match found
*/
	public Account searchId(UUID id)
	{
		for(Account student:database)
		{
			if((student.getID() == id))
			{
				return student;
			}
		}
		return null;
	}
	
/**
 * Adds student to the database
 */
	public boolean addStudent(String email, String password, String name)
	{
		if(this.searchEmail(email) == null)
		{
			database.add(new Account(email, password, name));
			
			this.save();
			
			return true;
		}
		return false;
	}
	
/**
 * Adds student with tutor permissions to database
 */
	public boolean addTutor(String email, String password, String name, boolean tutor)
	{
		if(this.searchEmail(email) == null)
		{
			database.add(new Account(email, password, name, tutor));
			
			this.save();
			
			return true;
		}
		return false;
	}
	
/**
 * Updates Account
*/
	public boolean updateAccount(String email, String password, String name)
	{
		Account temp = this.searchEmail(email);
		
		if (temp != null)
		{
			temp.setEmail(email);
			temp.setPassword(password);
			temp.setName(name);
			
			this.save();
			
			return true;
		}
		return false;
	}

/**
 * Deletes account
 */
	public boolean removeAccount(String email)
	{
		for (int x = 0; x < database.size(); x++)
		{
			if(database.get(x).getEmail().equals(email))
			{
				database.remove(x);
				
				Account.updateCount(-1);
				
				this.save();
		
				return true;
			}
		}
		return false;
	}

/**
 * Gets a list of all accounts by email
 */
	public ArrayList<Account> getAccountsByEmail(String email)
	{
		var acccountEmails = new ArrayList<Account>();
		
		for (int x = 0; x < database.size(); x++)
		{
			if(database.get(x).getEmail().equals(email))
			{
				acccountEmails.add(database.get(x));
			}
		}
		return acccountEmails;
	}
	
/**
* Sorts the database by title	
*/	
	public void sort()
	{
		Collections.sort(database);
	}
	
/**
* 	Writes the database back to the file
*/	
	public void save()
	{
		PrintWriter writer = null;

		try
		{
			writer = new PrintWriter(this.file);
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		for(int x = 0; x < database.size(); x++)
		{
			writer.write(database.get(x).toString());
			
			if(x != database.size() - 1)
			{
				writer.write("\n\n");
			}
		}
		writer.close();
	}
}
