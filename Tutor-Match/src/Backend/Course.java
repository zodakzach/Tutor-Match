package Backend;

public class Course implements Comparable<Course>
{
	private String field;
	private String courseNum;
	private String title;
	
	public Course(String courseNum, String title)
	{
		this.field = "CSCI";
		this.courseNum = courseNum;
		this.title = title;
	}

	public String getField()
	{
		return this.field;
	}
	
	public String getCourseNum()
	{
		return this.courseNum;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public int compareTo(Course course) 
	{
		return title.compareTo(course.title);
	}
	
	public boolean equals(Object obj)
    {
    	if(obj != null && obj instanceof Course)
    	{
    		Course temp = (Course) obj;
    		return this.courseNum == temp.courseNum;
    	}
    	return false;
    }
    
    public String toString()
    {
    	return String.format("%s%n%s%n%s%n", this.field, this.courseNum, this.title);
    }
}

