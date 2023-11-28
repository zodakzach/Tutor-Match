package Tutor_Source_Code;

import java.util.Date;
import java.util.UUID;

/**
 * The `Session` class represents a tutoring session between a student and a
 * tutor.
 */
public class Session {
	private UUID sessionId;
	private UUID studentId;
	private UUID tutorId;
	private Date startDate;
	private int sessionLengthHours;
	private boolean isCompleted;
	private Rating sessionRating;
	private Course course;

	/**
	 * Constructs a new tutoring session with the provided information.
	 *
	 * @param studentId          The unique identifier of the student.
	 * @param tutorId            The unique identifier of the tutor.
	 * @param startDate          The date and time when the session started.
	 * @param sessionLengthHours The duration of the session in hours.
	 */
	public Session(UUID studentId, UUID tutorId, Date startDate, int sessionLengthHours, Course course) {
		this.sessionId = UUID.randomUUID();
		this.studentId = studentId;
		this.tutorId = tutorId;
		this.startDate = startDate;
		this.sessionLengthHours = sessionLengthHours;
		this.isCompleted = false;
		this.sessionRating = Rating.NOT_RATED; // Set default rating as not rated
		this.course = course;
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

	/**
	 * Checks whether the session is marked as completed.
	 *
	 * @return {@code true} if the session is completed, {@code false} otherwise.
	 */
	public boolean isCompleted() {
		return this.isCompleted;
	}

	/**
	 * Sets the completion state of the session.
	 *
	 * @param newState The new completion state to set for the session.
	 */
	public void setIsCompleted(boolean newState) {
		this.isCompleted = newState;
	}

	/**
	 * Gets the unique identifier (UUID) associated with the session.
	 *
	 * @return The UUID of the session.
	 */
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
		return "Session{" + "studentId=" + studentId + ", tutorId=" + tutorId + ", startDate=" + startDate
				+ ", sessionLengthHours=" + sessionLengthHours + '}';
	}

	/**
	 * Get the rating for the session.
	 *
	 * @return The rating for the session.
	 */
	public Rating getSessionRating() {
		return sessionRating;
	}

	/**
	 * Set the rating for the session.
	 *
	 * @param sessionRating The rating to set for the session.
	 */
	public void setSessionRating(Rating sessionRating) {
		this.sessionRating = sessionRating;
	}
	
	/**
	 * Gets the course associated with the session.
	 *
	 * @return The course of the session.
	 */
	public Course getSessionCourse() {
		return this.course;
	}

}

/**
 * Enum representing the rating for a session.
 */
enum Rating {
	NOT_RATED(0), ONE_STAR(1), TWO_STARS(2), THREE_STARS(3), FOUR_STARS(4), FIVE_STARS(5);

	private final int value;

	Rating(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
    // Convert an int value to the corresponding Rating enum constant
    public static Rating fromValue(int value) {
        for (Rating rating : Rating.values()) {
            if (rating.getValue() == value) {
                return rating;
            }
        }
        throw new IllegalArgumentException("Invalid Rating value: " + value);
    }
}
