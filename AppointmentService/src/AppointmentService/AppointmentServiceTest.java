package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

	private AppointmentService service;
	private Date futureDate;

	@BeforeEach
	// Info before each test
	public void setUp() {
		service = new AppointmentService();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		futureDate = cal.getTime();
	}

	@Test
	// Test to add appointment
	public void testAddAppointment() {
		Appointment appointment = new Appointment("001", futureDate, "Doctor's Apt");
		service.addAppointment(appointment);
		assertEquals(appointment, service.getAppointment("001"));
	}

	@Test
	// Test to delete appointment
	public void testDeleteAppointment() {
		Appointment appointment = new Appointment("002", futureDate, "Doctor's Apt");
		service.addAppointment(appointment);
		service.deleteAppointment("002");
		assertNull(service.getAppointment("002"));
	}

	@Test
	// Test for duplicate appointment
	public void testAddDupAppointment() {
		Appointment appointment1 = new Appointment("003", futureDate, "Doctor's Apt1");
		Appointment appointment2 = new Appointment("003", futureDate, "Doctor's Apt2");
		service.addAppointment(appointment1);
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
	}
}
