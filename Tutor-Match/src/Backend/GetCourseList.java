package Backend;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/*
 * ECU Website of all Computer Science courses
 * https://catalog.ecu.edu/preview_program.php?catoid=28&poid=7403&hl=computer+science&returnto=search
 */
public class GetCourseList 
{
	public GetCourseList()
	{
		try 
		{
			String url = "https://catalog.ecu.edu/preview_program.php?catoid=28&poid=7403&hl=computer+science&returnto=search";
			Document doc = Jsoup.connect(url).get();

			// Find the course list section
			Element courseListSection = doc.select("div#coursestext").first();

			if (courseListSection != null) 
			{
				Elements courseRows = courseListSection.select("div.acalog-core");

				for (Element courseRow : courseRows) 
				{
					// Extract course details
					String courseCode = courseRow.select("a").text();
					String courseTitle = courseRow.select("div.title").text();
					String courseCredits = courseRow.select("div.credits").text();

					System.out.println("Course Code: " + courseCode);
					System.out.println("Course Title: " + courseTitle);
					System.out.println("Course Credits: " + courseCredits);
					System.out.println("---------------------------------------------------");
				}
			} 
			else 
			{
				System.out.println("Course list section not found on the page.");
			}
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
