package Tutor_Source_Code;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SuppressWarnings("unused")
public class GetCourseList extends CourseDatabase
{
	private CourseDatabase courseListMaster; // Master list of ECU courses for Computer Science BS
	private boolean loaded = true;
	private String file;
	private static final String URL = 
			"https://catalog.ecu.edu/preview_program.php?catoid=28&poid=7403&hl=%22computer+science%22&returnto=search";
	
/*
 * Constructor
 */
	public GetCourseList(String file)
	{
		courseListMaster = new CourseDatabase();
		
		this.file = file;
		
		this.load();
	}
	
	public void load()
	{
		if(loaded)
		{
			this.loadTXT();
		}
		else
		{
			this.loadHTML();
		}
	}
	
	public void loadTXT()
	{
		String field, title;
		int courseNum;
		
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

			field = reader.next();
			courseNum = Integer.parseInt(reader.next());
			title = reader.nextLine();
			
			temp = new Course(field, courseNum, title);
			
			courseListMaster.add(temp);
		}
		
		reader.close();
	}
	
	public void save_HTML_to_TXT()
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
		
		for(int x = 0; x < courseListMaster.size(); x++)
		{
			writer.write(courseListMaster.get(x).toString());
		}
		writer.close();
		
		this.loaded = true;
	}
/**
 * Gets courses from URL and stores in 'courseListMaster'
 */
	public void loadHTML()
	{
		String field, courseNum, title, line;

		try 
		{
			final Document DOCUMENT = Jsoup.connect(URL).get();

			for (Element row : DOCUMENT.select(".acalog-course a"))
			{
				line = row.text();

				field = line.substring(0, 4);
				courseNum = line.substring(5, 9);
				title = line.substring(12);

				courseListMaster.addCourse(field, Integer.parseInt(courseNum), title);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		this.save_HTML_to_TXT();
	}

/**
 * Displays all contents of courseListMaster as a String
 */
	public void display()
	{
		System.out.println();
		
		for(int x = 0; x < courseListMaster.size(); x++)
		{
			System.out.print(courseListMaster.get(x).toString());
			System.out.println();
		}
	}
	
/**
 * Searches course by course title
 * @param title
 * @returns matching course
 */
	public Course searchCourseTitle(String title)
	{
		return courseListMaster.searchCourseTitle(title);
	}
	
/**
* Searches course lists by course title
* @param title
* @returns a list of all courses matching title
*/
	public ArrayList<Course> getCoursesByTitle(String title)
	{
		return courseListMaster.getCoursesByTitle(title);
	}
	
/**
* Searches course lists by course field
* @param field
* @returns a list of all courses matching field
*/
	public ArrayList<Course> getCoursesByField(String field)
	{
		return courseListMaster.getCoursesByField(field);
	}
	
/**
* Searches course lists by course num
* @param num
* @returns a list of all courses matching num
*/
	public ArrayList<Course> getCoursesByNum(int num)
	{
		return courseListMaster.getCoursesByNum(num);
	}
	
/**
 * Adds a course to courseListMaster
 * @param field
 * @param courseNum
 * @param title
 * @returns true if added successfully; false if course already exists
 */
	public boolean addCourse(String field, int courseNum, String title)
	{
		return courseListMaster.addCourse(field, courseNum, title);
	}
}
