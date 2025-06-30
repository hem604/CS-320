package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	
	private ContactService service;
	private Contact contact;
	
	// Add contact before each test
	@BeforeEach
	public void setUp() {
		service = new ContactService();
		contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		service.addContact(contact);
	}
	// Test to add contact
	@Test 
	public void testAddContactPass() {
		Contact newContact = new Contact("00002", "Sam", "Smith", "0987654321", "321 Spring Rd");
		service.addContact(newContact);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(newContact);
		});
	}
	// Test to delete contact
	@Test
	public void testDeleteContactPass() {
		service.removeContact("00001");
		assertThrows(IllegalArgumentException.class, () -> {
			service.removeContact("00001");
		});
	}
	// Test to update first name
	@Test
	public void testUpdateFirstNamePass() {
		service.updateFirstName("00001", "Mac");
		assertEquals("Mac", contact.getFirstName());
	}
	// Test to update last name
	@Test
	public void testUpdateLastNamePass() {
		service.updateLastName("00001", "Brown");
		assertEquals("Brown", contact.getLastName());
	}
	// Test to update phone number
	@Test
	public void testUpdatePhoneNumPass() {
		service.updatePhoneNum("00001", "6543210987");
		assertEquals("6543210987", contact.getPhoneNum());
	}
	// Test for error if invalid phone number
	@Test 
	public void testUpdatePhoneNumFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNum("00001", "2222");
		});
	}
	// Test to update address
	@Test
	public void testUpdateAddressPass() {
		service.updateAddress("00001", "223 Palm Ave");
		assertEquals("223 Palm Ave", contact.getAddress());
	}
	// Test for error if invalid contact 
	@Test
	public void testUpdateInvalidContact() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("00000", "Vic");
		});
	}
  
}
