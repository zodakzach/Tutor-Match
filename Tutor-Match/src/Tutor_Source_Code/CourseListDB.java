package Tutor_Source_Code;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a database for storing and managing course lists for different accounts.
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
     * @param accountId   The unique identifier of the account.
     * @param courseList  The list of courses to associate with the account.
     */
    public void addCourseList(String accountId, ArrayList<Course> courseList) {
        courses.put(accountId, courseList);
        saveToJson();
    }

    /**
     * Retrieves the course list for a specific account.
     *
     * @param accountId The unique identifier of the account.
     * @return The list of courses associated with the specified account, or null if the account is not found.
     */
    public ArrayList<Course> getCourseList(String accountId) {
        return courses.get(accountId);
    }

    /**
     * Private method to save the course list data to a JSON file.
     */
    private void saveToJson() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(courses, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Private method to load course list data from a JSON file.
     */
    private void loadFromJson() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(file)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            courses = new HashMap<>();

            if (jsonObject != null) {
                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    String accountId = entry.getKey();
                    JsonElement value = entry.getValue();

                    if (value.isJsonArray()) {
                        JsonArray jsonArray = value.getAsJsonArray();
                        ArrayList<Course> courseList = new ArrayList<>();

                        for (int i = 0; i < jsonArray.size(); i++) {
                            Course course = gson.fromJson(jsonArray.get(i), Course.class);
                            courseList.add(course);
                        }

                        courses.put(accountId, courseList);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
