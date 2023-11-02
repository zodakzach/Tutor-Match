package Tutor_Source_Code;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TutorAvailability {
    private Map<DayOfWeek, AvailabilitySlot> availability;

    public TutorAvailability() {
        availability = new HashMap<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            availability.put(day, new AvailabilitySlot());
        }
    }

    // Set the availability for a specific day.
    public void setAvailability(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        AvailabilitySlot slot = availability.get(day);
        if (slot != null) {
            slot.setStartTime(startTime);
            slot.setEndTime(endTime);
        }
    }

    // Get the availability for a specific day.
    public AvailabilitySlot getAvailability(DayOfWeek day) {
        return availability.get(day);
    }

    // Define a class to represent an availability slot with start and end times.
    public static class AvailabilitySlot {
        private LocalTime startTime;
        private LocalTime endTime;

        public AvailabilitySlot() {
            this.startTime = LocalTime.of(0, 0);
            this.endTime = LocalTime.of(23, 59);
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime endTime) {
            this.endTime = endTime;
        }
    }
}
