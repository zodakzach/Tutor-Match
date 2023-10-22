package Backend;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class CourseDatabase 
{
	private static ArrayList<Course> database;
	private String file;
	
/**
 * Constructor with file name
 * - sets 'file' field
 * - loads course database
 * @param file
 */
	public CourseDatabase(String file)
	{
		database = new ArrayList<Course>();

		this.file = file;
		
		this.load();
	}
	
// *************************************************************
// The load() function may need to be modified depending on how the information is parsed
// from HTML
// **********************************************************
	public void load()
	{
		var line = new String[3];
		Scanner reader = null;
		Course temp = null;
		
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
			for(int x = 0; x < 3; x++)
			{
				line[x] = reader.nextLine();
			}
			
			temp = new Course(line[0], Integer.parseInt(line[1]), line[2]);
			
			database.add(temp);
			
			if(reader.hasNextLine())
			{
				reader.nextLine();
			}
		}
		
		reader.close();
	}
	
/**
 * Prints entire course list to console
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
 * Searches courses by course name
 * @param title - course name
 * @return found course, or null if no course found
 */
	public Course searchCourseTitle(String title)
	{
		for(Course c:database)
		{
			if((c.getTitle().equals(title)))
			{
				return c;
			}
		}
		return null;
	}
	
/**
 * Searches courses by course number
 * @param num - course number
 * @return found course, or null if no course found
 */
	public Course searchCourseNum(int num)
	{
		for(Course c:database)
		{
			if((c.getCourseNum() == num))
			{
				return c;
			}
		}
		return null;
	}

// ******************************************
// May need modifying depending on HTML parsing
// ********************************************
/**
 * Adds course to courselist
 * @param courseNum
 * @param title
 * @return true if courses added successfully; false is course already exists in list
 */
	public boolean addCourse(int courseNum, String title)
	{
		if(this.searchCourseNum(courseNum) == null)
		{
			database.add(new Course(courseNum, title));
			
			this.save();
			
			return true;
		}
		return false;
	}
	
/**
 * Old shell for returning a sublist from another list
 * - we may need it for the GUI when students are interacting with profile
 * - if we don't use it, we can just delete it later
 */
	public ArrayList<Course> getCoursesByNum(int num)
	{
		var coursesByNum = new ArrayList<Course>();
		
		for (int x = 0; x < database.size(); x++)
		{
			if(database.get(x).getCourseNum() == num)
			{
				coursesByNum.add(database.get(x));
			}
		}
		return coursesByNum;
	}
	
/**
 * Saves course list to text file
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
