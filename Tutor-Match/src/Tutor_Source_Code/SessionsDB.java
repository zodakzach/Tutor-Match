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
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.sessions = loadSessions();
    }

    /**
     * Load sessions from a JSON file.
     * @return List of Session objects or null if the file is empty or contains invalid data.
     */
    private List<Session> loadSessions() {
        try (Reader reader = new FileReader(filePath)) {
            // Define the type of object to deserialize
            Type sessionListType = new TypeToken<List<Session>>() {}.getType();

            // Deserialize the JSON data from the file into the 'sessions' collection
            sessions = gson.fromJson(reader, sessionListType);

            // Check if the sessions list is null or empty
            if (sessions == null || sessions.isEmpty()) {
                // Handle the case where the file is empty or contains invalid data
                return new ArrayList<Session>();
            }

            // Successfully loaded sessions
            return sessions;
        } catch (IOException e) {
            // Handle any IOException that might occur during file reading
            e.printStackTrace();
            return null; // or throw an exception if appropriate
        }
    }


    /**
     * Saves the sessions to the JSON file.
     */
    private void saveSessions() {
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
     * Deletes a session from the database based on the session ID.
     *
     * @param sessionId The UUID of the session to delete.
     */
    public void deleteSessionById(UUID sessionId) {
        // Find the session in the list based on the session ID
        for (Session session : sessions) {
            if (session.getSessionId().equals(sessionId)) {
                // Remove the session from the list
                sessions.remove(session);

                // Save the updated sessions to the JSON file
                saveSessions();
                return; // Exit the loop once the session is found and deleted
            }
        }

        // Handle the case where the specified session is not found
        System.out.println("Session not found.");
    }


    /**
     * Adds a session to the database.
     *
     * @param session The session object to add.
     */
    public void addSession(Session session) {
        sessions.add(session);
        saveSessions();
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
     * Retrieves a session by session ID.
     *
     * @param sessionId The UUID of the session.
     * @return A session associated with the specified session ID.
     */
    public Session getSessionById(UUID sessionId) {
        Session result = null;
        
        for (Session session : sessions) 
        {
            if (session.getSessionId().equals(sessionId)) 
            {
            	result = session;
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
    
    /**
     * Marks a session as completed and saves the updated sessions to the JSON file.
     *
     * @param session The session to mark as completed.
     */
    public void setSessionAsCompleted(Session session) {
        // Find the session in the list based on some unique identifier (e.g., session ID)
        for (Session existingSession : sessions) {
            if (existingSession.getSessionId().equals(session.getSessionId())) {
                // Mark the session as completed
                existingSession.setIsCompleted(true);

                // Save the updated sessions to the JSON file
                saveSessions();
                return; // Exit the loop once the session is found and updated
            }
        }

        // Handle the case where the specified session is not found
        System.out.println("Session not found or already marked as completed.");
    }
}

