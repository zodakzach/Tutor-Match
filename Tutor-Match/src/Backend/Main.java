package Backend;

import java.io.File;

@SuppressWarnings("unused")
public class Main 
{
//**********************************************************************************
// The file names are declared as fields just in case you guys need to change them on your computer
// This way the titles are easier to find and you don't need to sift through the code to change anything
//********************************************************************************************
	private static final String STUDENT_FILE = "src/Backend/studentDB.txt";
	private static final String COURSE_FILE = "src/Backend/coursesDB.txt";
	
	// file paths
	// ".getAbsolutetPath()" is used, so it should find the path on anyone's computer on its own
	private static final String STUDENT_PATH = new File(STUDENT_FILE).getAbsolutePath();
	private static final String COURSE_PATH = new File(COURSE_FILE).getAbsolutePath();

	// databases
	private static AccountDatabase student_database;
	private static CourseDatabase course_database;
	
	public static void main(String[] args) 
	{
		// INIT student and course databases
		student_database = new AccountDatabase(STUDENT_PATH); 
		course_database = new CourseDatabase(COURSE_PATH);
	}
}
