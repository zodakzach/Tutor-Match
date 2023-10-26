package Tutor_Source_Code;

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
	private static final String URL = 
			"https://catalog.ecu.edu/preview_program.php?catoid=28&poid=7403&hl=%22computer+science%22&returnto=search";
	
/*
 * Constructor
 */
	public GetCourseList()
	{
		courseListMaster = new CourseDatabase();
		
		// this.loadHTML();
	}
	
/**
 * Gets courses from URL and stores in 'courseListMaster'
 */
	private void loadHTML()
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
	}

/**
 * Displays all contents of courseListMaster as a String
 */
	public void display()
	{
		courseListMaster.display();
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
