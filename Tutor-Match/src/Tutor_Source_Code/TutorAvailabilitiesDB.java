package Tutor_Source_Code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.*;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class TutorAvailabilitiesDB {
	private String file; // The path to the JSON file.
	private Map<String, Map<DayOfWeek, TutorAvailability>> tutorAvailabilities;

	public TutorAvailabilitiesDB(String file) {
		
		this.file = file;
		
		tutorAvailabilities = new HashMap<>();
		
		loadFromJson();
	}

	// Add or update tutor availabilities for a specific account.
	public void addTutorAvailabilities(String accountId, Map<DayOfWeek, TutorAvailability> availabilities) {
		tutorAvailabilities.put(accountId, availabilities);
		saveToJson();
	}

	// Get tutor availabilities for a specific account.
	public Map<DayOfWeek, TutorAvailability> getTutorAvailabilities(String accountId) {
		return tutorAvailabilities.get(accountId);
	}

	// Delete tutor availabilities for a specific account.
	public void deleteTutorAvailabilities(String accountId) {
		
		tutorAvailabilities.remove(accountId);
		
		saveToJson();
	}

	// Private method to save tutor availabilities to a JSON file.
	private void saveToJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try (Writer writer = new FileWriter(file)) 
		{
			gson.toJson(tutorAvailabilities, writer);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Private method to load tutor availabilities from a JSON file.
	private void loadFromJson() {
		Gson gson = new Gson();
		try (Reader reader = new FileReader(file))
		{
			Type type = new TypeToken<Map<String, Map<DayOfWeek, TutorAvailability>>>() {
			}.getType();
			
			tutorAvailabilities = gson.fromJson(reader, type);
			
			if (tutorAvailabilities == null) 
			{
				tutorAvailabilities = new HashMap<>();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
