package Tutor_Source_Code;

import java.io.File;

public class Main 
{
//******************************************************************************************************
// The file names are declared as fields just in case you guys need to change them on your computer
// This way the titles are easier to find and you don't need to sift through the code to change anything
//******************************************************************************************************
	private static final String ACCOUNT_FILE = "src/Databases/accounts.json";
	private static final String COURSE_FILE = "src/Databases/courseLists.json";
	
	// private static final String STUDENT_FILE = "src/Databases/studentDB.txt";
	// private static final String COURSE_FILE = "src/Databases/master_coursesDB.txt";l
	
	// file paths
	// ".getAbsolutetPath()" is used, so it should find the path on anyone's computer on its own
	private static final String ACCOUNT_PATH = new File(ACCOUNT_FILE).getAbsolutePath();
	private static final String COURSE_PATH = new File(COURSE_FILE).getAbsolutePath();

	// databases
	private static AccountDB student_database_master;
	private static CourseListDB course_database_master;
	
	//The ID for the ECU Catalog courseList in the courseList database
	private static final String ECU_CATALOG = "ECU Course Catalog";

	private static CourseCatalog catalog = new CourseCatalog();
	
	public static void main(String[] args) 
	{
		// __INIT__ student database
		student_database_master = new AccountDB(ACCOUNT_PATH); 
		
		// __INIT__ MASTER course list database
		course_database_master = new CourseListDB(COURSE_PATH);

		// Update the ECU Course Catalog in the database from web-site
		course_database_master.addCourseList(ECU_CATALOG, catalog.getCourseCatalog());
		
		// course_database_master = new GetCourseList(COURSE_FILE); // This is part of the Deprecated code
		
		LoginUI.__PROGRAM_INIT__(student_database_master, course_database_master);
				
		
		// -- TEST CODE --
		// comment out and in as needed to test cases
		// "ctrl" + "shift" will comment out blocks of code
		
		// student_database.addStudent("email@email.com", "1234", "Ashitaka");
		// course_database.display();
	}
}
