package Tutor_Source_Code;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a database for storing and managing course lists for
 * different accounts.
 */
public class CourseListDB {
	private String file; // The file path to store the course list data.
	private Map<String, ArrayList<Course>> courses; // A mapping of account IDs to their associated course lists.

	/**
	 * Constructs a new CourseListDB instance.
	 *
	 * @param file The path to the JSON file used to store course list data.
	 */
	public CourseListDB(String file) {
		this.file = file;
		courses = new HashMap<>();
		loadFromJson();
	}

	/**
	 * Adds or updates a course list for a specific account.
	 *
	 * @param accountId  The unique identifier of the account.
	 * @param courseList The list of courses to associate with the account.
	 */
	public void addCourseList(String accountId, ArrayList<Course> courseList) {
		courses.put(accountId, courseList);
		saveToJson();
	}

	/**
	 * Retrieves the course list for a specific account.
	 *
	 * @param accountId The unique identifier of the account.
	 * @return The list of courses associated with the specified account, or null if
	 *         the account is not found.
	 */
	public ArrayList<Course> getCourseList(String accountId) {
		return courses.get(accountId);
	}

	/**
	 * Private method to save the course list data to a JSON file.
	 */
	private void saveToJson() {
		Gson gson = new Gson();
		try (Writer writer = new FileWriter(file)) 
		{
			gson.toJson(courses, writer);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Private method to load course list data from a JSON file.
	 */
	private void loadFromJson() {
	    // Create a Gson object for JSON deserialization
	    Gson gson = new Gson();

	    try (Reader reader = new FileReader(file)) 
	    {
	        // Deserialize the JSON data from the file into a JsonObject
	        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

	        if (jsonObject != null) 
	        {
	            // Iterate through the entries (key-value pairs) in the JsonObject
	            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) 
	            {
	                // Extract the account ID (key) and its associated JSON value
	                String accountId = entry.getKey();
	                JsonElement value = entry.getValue();

	                // Check if the JSON value is an array
	                if (value.isJsonArray()) 
	                {
	                    JsonArray jsonArray = value.getAsJsonArray();
	                    ArrayList<Course> courseList = new ArrayList<>();

	                    // Iterate through the elements in the JSON array
	                    for (int i = 0; i < jsonArray.size(); i++) 
	                    {
	                        // Deserialize each element into a Course object
	                        Course course = gson.fromJson(jsonArray.get(i), Course.class);
	                        courseList.add(course);
	                    }

	                    // Populate the 'courses' HashMap with the account ID and associated course list
	                    courses.put(accountId, courseList);
	                }
	            }
	        }
	    } 
	    catch (IOException e) 
	    {
	        // Handle any IOException that might occur during file reading
	        e.printStackTrace();
	    }
	}

	/**
	 * Finds account IDs that have the specified course in their course list.
	 *
	 * @param courseName The name of the course to search for.
	 * @return A list of account IDs that have the course in their course list. An
	 *         empty list is returned if no matches are found.
	 */
	private List<String> findAccountsByCourse(String courseName) {
		List<String> matchingAccountIds = new ArrayList<>();

		for (Map.Entry<String, ArrayList<Course>> entry : courses.entrySet()) 
		{
			ArrayList<Course> courseList = entry.getValue();
			
			if (courseList != null) 
			{
				for (Course course : courseList) 
				{
					if (course != null && course.toString().equalsIgnoreCase(courseName)) 
					{
						matchingAccountIds.add(entry.getKey()); // Found the course in this account's list.
						break; // No need to continue checking this account's course list.
					}
				}
			}
		}
		return matchingAccountIds; // List of account IDs with the course.
	}

	/**
	 * Finds account IDs of accounts that have at least one of the courses from a
	 * given course list in their course list.
	 *
	 * @param courseList The list of courses to search for in account course lists.
	 * @return A list of account IDs that have at least one of the courses in their
	 *         course list.
	 */
	public List<String> findAccountsByCourseList(ArrayList<Course> courseList) {
		List<String> matchingAccountIds = new ArrayList<>();

		for (Course course : courseList) 
		{
			List<String> accountIds = findAccountsByCourse(course.toString());

			if (!accountIds.isEmpty()) 
			{
				matchingAccountIds.addAll(accountIds);
			}
		}

		// Remove duplicates, if any, from the list of matching account IDs.
		Set<String> uniqueMatchingAccountIds = new HashSet<>(matchingAccountIds);
		
		return new ArrayList<>(uniqueMatchingAccountIds);
	}

	/**
	 * Removes the course list associated with a specific account.
	 *
	 * @param accountId The unique identifier of the account.
	 * @return true if the course list was successfully removed, false if the
	 *         account does not exist.
	 */
	public boolean removeCourseList(String accountId) {
		if (courses.containsKey(accountId)) 
		{
			courses.remove(accountId);
			saveToJson(); // Save the updated course list data to the JSON file.
			return true; // Course list successfully removed.
		}
		return false; // Account does not exist, course list not removed.
	}

}
