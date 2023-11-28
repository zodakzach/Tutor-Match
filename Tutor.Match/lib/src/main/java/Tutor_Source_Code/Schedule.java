package Tutor_Source_Code;

import java.util.HashMap;
import java.util.Map;

public class Schedule 
{
	
	Map<Integer, ACCESS> hours; // dictionary holding a boolean value for each hour of a day
	Map<Integer, Map<Integer, ACCESS>> schedule; // dictionary holding the dictionary of days
	
/**
 * Sets availability to NOT for every instance of time
 */
	public Schedule()
	{
		schedule = new HashMap<Integer, Map<Integer, ACCESS>>();
		
		for (int day = 0; day < 7; day++) 
		{
			hours = new HashMap<>();
            
            for (int hour = 0; hour < 24; hour++) 
            {
            	hours.put(hour, ACCESS.NOT);
            }
            
            schedule.put(day, hours);
        }
	}
	
/**
 * Changes specific times to 1 to mark as "available"	
 * @param day
 * @param time
 */
	public void setSchedule(int day, int hour, ACCESS avail )
	{
		schedule.get(day).put(hour, avail);
	}
	
/**
 * Gets entire schedule
 * @return
 */
	public Map<Integer, Map<Integer, ACCESS>> getSchedule()
	{
		return this.schedule;
	}
	
/**
 * Gets availability by day
 * @param weekday
 * @return
 */
	public Map<Integer, ACCESS> getDay(int day)
	{
		return schedule.get(day);
	}
	
/**
 * Gets availability by hour
 * @param weekday
 * @param hour
 * @return
 */
	public int getAvailInt(int day, int hour)
	{
		return schedule.get(day).get(hour).getNum();
	}
	
/**
 * returns ACCESS to check availability 
 * @param day
 * @param hour
 * @return
 */
	public ACCESS getAccess(int day, int hour)
	{
		return schedule.get(day).get(hour);
	}
	
/**
 * Updates this.schedule with newSchedule
 * @param newSchedule
 */
	public void changeSchedule(Schedule newSchedule)
	{
		schedule = newSchedule.getSchedule();
	}
	
/**
 * Makes sure there is availability during a time so there isn't overlap
 * @param weekday
 * @param hour
 * @return
 */
	public boolean scheduleSession(int weekday, int hour)
	{
		if(this.getAvailInt(weekday, hour) < 1)
		{
			return false;
		}
		
		schedule.get(weekday).put(hour, ACCESS.BUSY);
		
		return true;
	}
}

enum ACCESS 
{
	FREE(1), // AVAILABLE
	BUSY(0), // NORMALLY AVAILABLE, BUT EVENT SCHEDULED
	NOT(-1); // UNAVAILABLE; BLACKED OUT DATE
	
	private final int AVAILABILITY;

	ACCESS(int avail) 
	{
        this.AVAILABILITY = avail;
    }

    public int getNum() 
    {
        return AVAILABILITY;
    }
}
