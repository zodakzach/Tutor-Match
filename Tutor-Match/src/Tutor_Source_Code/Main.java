package Tutor_Source_Code;

import java.io.File;

@SuppressWarnings("unused")
public class Main 
{
//**********************************************************************************
// The file names are declared as fields just in case you guys need to change them on your computer
// This way the titles are easier to find and you don't need to sift through the code to change anything
//********************************************************************************************
	private static final String STUDENT_FILE = "src/Databases/studentDB.txt";
	private static final String COURSE_FILE = "src/Databases/master_coursesDB.txt";
	
	// file paths
	// ".getAbsolutetPath()" is used, so it should find the path on anyone's computer on its own
	private static final String STUDENT_PATH = new File(STUDENT_FILE).getAbsolutePath();
	private static final String COURSE_PATH = new File(COURSE_FILE).getAbsolutePath();

	// databases
	private static AccountDatabase student_database_master;
	private static GetCourseList course_database_master;
	
	public static void main(String[] args) 
	{
		// __INIT__ student database
		student_database_master = new AccountDatabase(STUDENT_PATH); 
		
		// __INIT__ MASTER course list database
		course_database_master = new GetCourseList(COURSE_FILE);
		
		LoginUI.__PROGRAM_INIT__(student_database_master, course_database_master);
		
		course_database_master.display();
		
		
		// -- TEST CODE --
		// comment out and in as needed to test cases
		// "ctrl" + "shift" will comment out blocks of code
		
		// student_database.addStudent("email@email.com", "1234", "Ashitaka");
		// course_database.display();
	}
}
