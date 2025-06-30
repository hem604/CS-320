package AppointmentService;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
	// Store appointments in an Array List
	private final List<Appointment> appointments = new ArrayList<>();

	// Add a new appointment
	public void addAppointment(Appointment appointment) {
		// Check for null
		if (appointment == null) {
			throw new IllegalArgumentException("Must Have Appointment");
		}
		// Check for duplicate
		for (Appointment a : appointments) {
			if (a.getAppointmentId().equals(appointment.getAppointmentId())) {
				throw new IllegalArgumentException("Duplicate ID");
			}
		}
		// If ok add to list
		appointments.add(appointment);
	}

	// Remove appointment by ID
	public void deleteAppointment(String appointmentId) {
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
				appointments.remove(i);
				return;
			}
		}
		// Error if none found
		throw new IllegalArgumentException("No Appointment Found");
	}

	// Show appointment by ID
	public Appointment getAppointment(String appointmentId) {
		for (Appointment appointment : appointments) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				return appointment;
			}
		}
		return null;
	}
}
