package Tutor_Source_Code;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * A class to retrieve and store a catalog of courses from ECU's Computer Science program.
 */
public class CourseCatalog {
    private ArrayList<Course> courseCatalog; // Master list of ECU courses for Computer Science BS
    private static final String URL =
            "https://catalog.ecu.edu/preview_program.php?catoid=28&poid=7403&hl=%22computer+science%22&returnto=search";

    /**
     * Constructs a CourseCatalog object and initializes the course catalog by loading data from a URL.
     */
    CourseCatalog() {
        courseCatalog = new ArrayList<Course>();
        loadHTML();
    }

    /**
     * Retrieves and stores courses from the specified URL in the 'courseCatalog'.
     */
    private void loadHTML() {
        String field, courseNum, title, line;

        try {
            final Document DOCUMENT = Jsoup.connect(URL).get();

            for (Element row : DOCUMENT.select(".acalog-course a")) 
            {
                line = row.text();

                field = line.substring(0, 4);
                courseNum = line.substring(5, 9);
                title = line.substring(12);

                Course course = new Course(field, Integer.parseInt(courseNum), title);

                courseCatalog.add(course);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Returns the list of courses in the catalog.
     *
     * @return An ArrayList of Course objects representing the course catalog.
     */
    public ArrayList<Course> getCourseCatalog() {
        return courseCatalog;
    }
}

