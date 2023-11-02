package DEPRECATED;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Tutor_Source_Code.Course;

@SuppressWarnings("unused")
public class CourseDatabase 
{
	private ArrayList<Course> database;
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

/**
 * Constructor for course list from HTML
 * - course is website, so no txt file necessary to store the courses
 */
	public CourseDatabase()
	{
		database = new ArrayList<Course>();
	}
	
	public ArrayList<Course> getAllCourses(){
		return database;
	}

/**
 * Loads database from .txt file
 */
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
 * Adds course to courselist
 * @param courseNum
 * @param title
 * @return true if courses added successfully; false is course already exists in list
 */
	public boolean addCourse(String field, int courseNum, String title)
	{
		if(this.searchCourseTitle(title) == null)
		{
			database.add(new Course(field, courseNum, title));
			
			return true;
		}
		return false;
	}
	
/**
* Searches course lists by course num
* @param num
* @returns a list of all courses matching num
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
* Searches course lists by course title
* @param title
* @returns a list of all courses matching title
*/
	public ArrayList<Course> getCoursesByTitle(String title)
	{
		var coursesByTitle = new ArrayList<Course>();
		
		for (int x = 0; x < database.size(); x++)
		{
			if(database.get(x).getTitle().equals(title))
			{
				coursesByTitle.add(database.get(x));
			}
		}
		return coursesByTitle;
	}
	
/**
* Searches course lists by course field
* @param field
* @returns a list of all courses matching field
*/
	public ArrayList<Course> getCoursesByField(String field)
	{
		var coursesByField = new ArrayList<Course>();
		
		for (int x = 0; x < database.size(); x++)
		{
			if(database.get(x).getField().equals(field))
			{
				coursesByField.add(database.get(x));
			}
		}
		return coursesByField;
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
	
	public void sort()
	{
		Collections.sort(database);
	}
	
	public Course get(int x)
	{
		return database.get(x);
	}
	
	public void add(Course x)
	{
		database.add(x);
	}
	
	public int size()
	{
		return database.size();
	}
}
