package contacts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	// Test to create a valid contact 
	@Test
	public void testValidContact() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertEquals("00001", contact.getContactId());
		assertEquals("Hana", contact.getFirstName());
		assertEquals("Moskovitz", contact.getLastName());
		assertEquals("1234567890", contact.getPhoneNum());
		assertEquals("212 Muir St", contact.getAddress());
	}
	
	//ID
	// Test if Id is null
	@Test
	public void testContactIdIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Hana", "Moskovitz", "1234567890", "212 Muir St");
		});
	}
	// Test if Id is too long
	@Test
	public void testContactIdIsTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		});
	}
	
	//First name
	// Test if first name is null
	@Test
	public void testFirstNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", null, "Moskovitz", "1234567890", "212 Muir St");
		});
	}
	// Test if first name is too long
	@Test
	public void testFirstNameIsTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", "Haaaaaaaaaaana", "Moskovitz", "1234567890", "212 Muir St");
		});
	}
	
	//Last name
	// Test if last name is null
	@Test
	public void testLastNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", "Hana", null, "1234567890", "212 Muir St");
		});
	}
	// Test if last name is too long	
	@Test
	public void testLastNameIsTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Hana", "Moskovitzzzzzz", "1234567890", "212 Muir St");
		});
	}
	
	//Phone Number
	// Test if phone number is null, too short, or too long
	@Test
	public void testPhoneNumIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", "Hana", "Moskovitz", null, "212 Muir St");
		});
	}
	// Test if phone number too short
	@Test
	public void testPhoneNumIsTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", "Hana", "Moskovitz", "123", "212 Muir St");
		});
	}
	// Test if phone number is too long
	@Test
	public void testPhoneNumIsTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", "Hana", "Moskovitz", "12345678901", "212 Muir St");
		});
	}
	
	//Address
	// Test is address is null
	@Test
	public void testAddressIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", "Hana", "Moskovitz", "1234567890", null);
		});
	}
	// Test is address is too long
	@Test
	public void testAddressIsTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muuuuuuuuuuuuir Streeeeeeeeeeeeeeet");
		});
	}
	
	
	// test setters
	@Test
	public void testSetValidContact() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212Muir St");
		
		contact.setFirstName("Sam");
		assertEquals("Sam", contact.getFirstName());
		
		contact.setLastName("Smith");
		assertEquals("Smith", contact.getLastName());
		
		contact.setPhoneNum("0987654321");
		assertEquals("0987654321", contact.getPhoneNum());
		
		contact.setAddress("321 Spring Rd");
		assertEquals("321 Spring Rd", contact.getAddress());
	}
	//First name
	// Test if first name is null
	@Test
	public void testFirstNameSetNull() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}
	// Test if first name is too long
	@Test
	public void testFirstNameSetTooLong() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Haaaaaaaaaaana"));
	}

	
	//Last name
	// Test if last name is null
	@Test
	public void testLastNameSetNull() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
	}
	// Test if last name is too long	
	@Test
	public void testLastNameSetTooLong() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Moskovitzzzzzz"));
	}

	
	//Phone Number
	// Test if phone number is null, too short, or too long
	@Test
	public void testPhoneNumSetNull() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum(null));
	}
	// Test if phone number too short
	@Test
	public void testPhoneNumSetTooShort() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum("123"));
	}
	// Test if phone number is too long
	@Test
	public void testPhoneNumSetTooLong() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum("12345678901"));
	}
	
	//Address
	// Test is address is null
	@Test
	public void testAddressSetNull() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}
	// Test is address is too long
	@Test
	public void testAddressSetTooLong() {
		Contact contact = new Contact("00001", "Hana", "Moskovitz", "1234567890", "212 Muir St");
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress("212 Muuuuuuuuuuuuir Streeeeeeeeeeeeeeet"));
	}


}
