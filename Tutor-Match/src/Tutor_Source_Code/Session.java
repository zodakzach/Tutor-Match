package Tutor_Source_Code;

import java.util.Date;
import java.util.UUID;

/**
 * The `Session` class represents a tutoring session between a student and a tutor.
 */
public class Session {
	private UUID sessionId;
    private UUID studentId;
    private UUID tutorId;
    private Date startDate;
    private int sessionLengthHours;
    private boolean isCompleted;

    /**
     * Constructs a new tutoring session with the provided information.
     *
     * @param studentId The unique identifier of the student.
     * @param tutorId   The unique identifier of the tutor.
     * @param startDate The date and time when the session started.
     * @param sessionLengthHours The duration of the session in hours.
     */
    public Session(UUID studentId, UUID tutorId, Date startDate, int sessionLengthHours) {
		this.sessionId = UUID.randomUUID();
        this.studentId = studentId;
        this.tutorId = tutorId;
        this.startDate = startDate;
        this.sessionLengthHours = sessionLengthHours;
        this.isCompleted = false;
    }

    /**
     * Get the unique identifier of the student associated with this session.
     *
     * @return The student's unique identifier.
     */
    public UUID getStudentId() {
        return studentId;
    }

    /**
     * Get the unique identifier of the tutor associated with this session.
     *
     * @return The tutor's unique identifier.
     */
    public UUID getTutorId() {
        return tutorId;
    }

    /**
     * Get the date and time when the session started.
     *
     * @return The start date of the session.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the date and time when the session started.
     *
     * @param startDate The new start date for the session.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the duration of the session in hours.
     *
     * @return The length of the session in hours.
     */
    public int getSessionLengthHours() {
        return sessionLengthHours;
    }

    /**
     * Set the duration of the session in hours.
     *
     * @param sessionLengthHours The new length of the session in hours.
     */
    public void setSessionLengthHours(int sessionLengthHours) {
        this.sessionLengthHours = sessionLengthHours;
    }
    
    public boolean isCompleted() {
    	return this.isCompleted;
    }
    
    public void setIsCompleted(boolean newState) {
    	this.isCompleted = newState;
    }
    
    public UUID getSessionId() {
    	return this.sessionId;
    }

    /**
     * Get a string representation of the session.
     *
     * @return A string representation of the session's information.
     */
    @Override
    public String toString() {
        return "Session{" +
                "studentId=" + studentId +
                ", tutorId=" + tutorId +
                ", startDate=" + startDate +
                ", sessionLengthHours=" + sessionLengthHours +
                '}';
    }
}

