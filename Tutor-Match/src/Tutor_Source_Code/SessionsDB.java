package Tutor_Source_Code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * The SessionsDB class represents a database for managing tutor sessions.
 */
public class SessionsDB {
    /**
     * List of session objects in the database.
     */
    private List<Session> sessions;

    /**
     * File path to the JSON file used for data storage and retrieval.
     */
    private String filePath;

    /**
     * Gson object for JSON serialization and deserialization.
     */
    private Gson gson;

    /**
     * Constructs a SessionsDB instance with the specified file path.
     *
     * @param filePath The file path to the JSON file for storing session data.
     */
    public SessionsDB(String filePath) {
        this.filePath = filePath;
        this.sessions = new ArrayList<>();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Loads sessions from the JSON file into the database.
     */
    public void loadSessions() {
        try (Reader reader = new FileReader(filePath)) 
        {
            // Define the type of object to deserialize
            Type sessionListType = new TypeToken<List<Session>>(){}.getType();

            // Deserialize the JSON data from the file into the 'sessions' collection
            sessions = gson.fromJson(reader, sessionListType);
        } 
        catch (IOException e) 
        {
            // Handle any IOException that might occur during file reading
            e.printStackTrace();
        }
    }

    /**
     * Saves the sessions to the JSON file.
     */
    public void saveSessions() {
        try (Writer writer = new FileWriter(filePath)) 
        {
            // Serialize the 'sessions' collection to JSON and write it to the file
            gson.toJson(sessions, writer);
        } 
        catch (IOException e) 
        {
            // Handle any IOException that might occur during file writing
            e.printStackTrace();
        }
    }

    /**
     * Adds a session to the database.
     *
     * @param session The session object to add.
     */
    public void addSession(Session session) {
        sessions.add(session);
    }

    /**
     * Retrieves sessions by tutor ID.
     *
     * @param tutorId The UUID of the tutor.
     * @return A list of sessions associated with the specified tutor ID.
     */
    public List<Session> getSessionsByTutorId(UUID tutorId) {
        List<Session> result = new ArrayList<>();
        for (Session session : sessions) 
        {
            if (session.getTutorId().equals(tutorId)) 
            {
                result.add(session);
            }
        }
        return result;
    }

    /**
     * Retrieves sessions by student ID.
     *
     * @param studentId The UUID of the student.
     * @return A list of sessions associated with the specified student ID.
     */
    public List<Session> getSessionsByStudentId(UUID studentId) {
        List<Session> result = new ArrayList<>();
        
        for (Session session : sessions) 
        {
            if (session.getStudentId().equals(studentId)) 
            {
                result.add(session);
            }
        }
        return result;
    }

    /**
     * Retrieves all sessions in the database.
     *
     * @return A list of all sessions stored in the database.
     */
    public List<Session> getAllSessions() {
        return sessions;
    }
}
