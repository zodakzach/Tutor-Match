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
	// private static final int ACCOUNT_SIZE = 6;
	private String file;
	
	public CourseDatabase(String file)
	{
		database = new ArrayList<Course>();

		this.file = file;
		
		this.load();
	}
	
// *************************************************************
// This function will have to be modified depending on how the information is formatted 
// from parsing the html
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
			
			temp = new Course(line[0], line[1]);
			
			database.add(temp);
			
			if(reader.hasNextLine())
			{
				reader.nextLine();
			}
		}
		
		reader.close();
	}
	
	public void display()
	{
		System.out.printf("%n%n");
		
		for(int x = 0; x < database.size(); x++)
		{
			System.out.print(database.get(x).toString());
			
			if(x != database.size() - 1)
			{
				System.out.print("\n\n");
			}
		}
	}
	
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
	
	public Course searchCourseNum(String num)
	{
		for(Course c:database)
		{
			if((c.getCourseNum().equals(num)))
			{
				return c;
			}
		}
		return null;
	}
	
	public boolean addCourse(String courseNum, String title)
	{
		if(this.searchCourseNum(courseNum) == null)
		{
			database.add(new Course(courseNum, title));
			
			this.save();
			
			return true;
		}
		return false;
	}
	
	public ArrayList<Course> getCoursesByNum(String num)
	{
		var coursesByNum = new ArrayList<Course>();
		
		for (int x = 0; x < database.size(); x++)
		{
			if(database.get(x).getCourseNum().equals(num))
			{
				coursesByNum.add(database.get(x));
			}
		}
		return coursesByNum;
	}
	
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
