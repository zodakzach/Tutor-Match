package Tutor_Source_Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Schedule<day> 
{
// *******************************************************************
//  Not sure if we'll need these yet, but I went ahead an put them in just in case 
	private static final int SUNDAY = 0;
	private static final int MONDAY = 1;
	private static final int TUESDAY = 2;
	private static final int WEDNESDAY = 3;
	private static final int THURSDAY = 4;
	private static final int FRIDAY = 5;
	private static final int SATURDAY = 6;
	
	Map<Integer, Boolean> hours; // dictionary holding a boolean value for each hour of a day
	Map<Integer, Map<Integer, Boolean>> weekdays; // dictionary holding the dictionary of days
	
/**
 * Sets availability to false for every instance of time
 */
	public Schedule()
	{
		weekdays = new HashMap<Integer, Map<Integer, Boolean>>();
		
		for (int day = 0; day < 7; day++) 
		{
			hours = new HashMap<>();
            
            for (int time = 0; time < 24; time++) 
            {
            	hours.put(time, false);
            }
            
            weekdays.put(day, hours);
        }
	}
	
/**
 * Changes specific times to 1 to mark as "available"	
 * @param day
 * @param time
 */
	public void setSchedule(int weekday, int hour, boolean avail )
	{
		weekdays.get(weekday).put(hour, avail);
	}
	
	public Map<Integer, Map<Integer, Boolean>> getSchedule()
	{
		return this.weekdays;
	}
	
	public Map<Integer, Boolean> getDay(int weekday)
	{
		return weekdays.get(weekday);
	}
	
	public boolean getAvailability(int weekday, int hour)
	{
		return weekdays.get(weekday).get(hour);
	}
}
