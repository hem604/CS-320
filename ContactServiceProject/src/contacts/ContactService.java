package contacts;

import java.util.ArrayList;
import java.util.List;

// Store contacts in an Array List
public class ContactService {
	private final List<Contact> contacts = new ArrayList<>();
	// Add unique contact
	public void addContact(Contact contact) {
		if (getContactsId(contact.getContactId()) != null) {
			throw new IllegalArgumentException("Contact ID Already Exists");
		}
		contacts.add(contact);
	}
	// Remove contact
	public void removeContact(String contactId) {
		Contact contact = getContactsId(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact Not Found");
		}
		contacts.remove(contact);
	}
	// Update first name
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = getContactOrError(contactId);
		contact.setFirstName(firstName);
	}
	// Update last name
	public void updateLastName(String contactId, String lastName) {
		Contact contact = getContactOrError(contactId);
		contact.setLastName(lastName);
	}
	// Update phone number
	public void updatePhoneNum(String contactId, String phoneNum) {
		Contact contact = getContactOrError(contactId);
		contact.setPhoneNum(phoneNum);
	}
	// Update address
	public void updateAddress(String contactId, String address) {
		Contact contact = getContactOrError(contactId);
		contact.setAddress(address);
	}
	// Helper
	private Contact getContactsId(String contactID) {
		for (Contact contact : contacts) {
			if (contact.getContactId().equals(contactID)) {
				return contact;
			}	
		}
		return null;
	}
	// Error if no contact
	private Contact getContactOrError(String contactId) {
		Contact contact = getContactsId(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact Can't Be Found");
		}
		return contact;
	}
	
}

