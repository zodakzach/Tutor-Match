package Tutor_Source_Code;

import java.util.Date;
import java.util.UUID;

public class Session {
    private UUID studentId;
    private UUID tutorId;
    private Date startDate;
    private int sessionLengthHours;

    public Session(UUID studentId, UUID tutorId, Date startDate, int sessionLengthHours) {
        this.studentId = studentId;
        this.tutorId = tutorId;
        this.startDate = startDate;
        this.sessionLengthHours = sessionLengthHours;
    }

    public UUID getStudentId() {
        return studentId;
    }


    public UUID getTutorId() {
        return tutorId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getSessionLengthHours() {
        return sessionLengthHours;
    }

    public void setSessionLengthHours(int sessionLengthHours) {
        this.sessionLengthHours = sessionLengthHours;
    }

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
