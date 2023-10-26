package Tutor_Source_Code;

@SuppressWarnings("unused")
public class Course implements Comparable<Course>
{
	private String field;
	private Integer courseNum; // wrapper class used so courseNum can be used with .compareTo() function
	private String title;
	
/**
 * Constructor where CSCI is already set to field
 * @param courseNum
 * @param title
 */
	public Course(int courseNum, String title)
	{
		this.field = "CSCI"; 
		this.courseNum = courseNum;
		this.title = title;
	}
	
/**
 * Constructor where the field can be passed
 * @param field
 * @param courseNum
 * @param title
 */
	public Course(String field, int courseNum, String title)
	{
		this.field = field; 
		this.courseNum = courseNum;
		this.title = title;
	}

/**
 * Returns this.field
 * @return
 */
	public String getField()
	{
		return this.field;
	}
	
/**
 * Returns this.courseNum
 * @return
 */
	public int getCourseNum()
	{
		return this.courseNum;
	}
	
/**
 * Returns this.title
 * @return
 */
	public String getTitle()
	{
		return this.title;
	}
	
/**
 * Function used for sorting in the collections.sort framework
 */
	public int compareTo(Course course) 
	{
		return this.courseNum.compareTo(course.courseNum);
	}
	
/**
 * Checks this.object to argument object for equality
 * - part of collections framework
 */
	public boolean equals(Object obj)
    {
    	if(obj != null && obj instanceof Course)
    	{
    		Course temp = (Course) obj;
    		return this.courseNum == temp.courseNum;
    	}
    	return false;
    }
    
/**
 * Returns this.Course as a string
 */
    public String toString()
    {
    	return String.format("%s%n%d%n%s", this.field, this.courseNum, this.title);
    }
}

