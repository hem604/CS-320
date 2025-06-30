package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

	// Helpers: get future date
	private Date getFutureDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	// Check past date
	private Date getPastDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	@Test
	// Test to create a valid appointment
	public void testValidAppointment() {
		Date futureDate = getFutureDate();
		Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's Apt");
		assertEquals("1234567890", appointment.getAppointmentId());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("Doctor's Apt", appointment.getDescription());
	}

	@Test
	// Test if Id is Null
	public void testNullAppointmentId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, getFutureDate(), "Doctors Apt");
		});
	}

	@Test
	// Test is Id is too long (must be > 10)
	public void testLongAppointmentId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("11223344556677889900", getFutureDate(), "Doctors Apt");
		});
	}

	@Test
	// Test if date is a past date (cannot be in the past)
	public void testPastAppointmentDate() {
		Date pastDate = getPastDate();
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("003", pastDate, "Doctors Apt");
		});
	}

	@Test
	// Test if date is Null
	public void testNullAppointmentDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("004", null, "Doctors Apt");
		});
	}

	@Test
	// Test if description is Null
	public void testNullDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("004", getFutureDate(), null);
		});
	}

	@Test
	// Test if description is too long (must be > 50)
	public void testLongDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("004", getFutureDate(), "Iamgoingtobegoingtoseethedoctorstodayandseewhattheycanfind");
		});
	}
}
