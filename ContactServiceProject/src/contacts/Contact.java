package contacts;

// Requirements
public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
// Constructor
	public Contact(String contactId, String firstName, String lastName, String phoneNum, String address) {
		if (contactId == null || contactId.length() > 10)
			throw new IllegalArgumentException("Invalid Contact ID");
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("Invalid First Name");
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Invalid Last Name");
		if (phoneNum == null || phoneNum.length() != 10)
			throw new IllegalArgumentException("Invalid Phone Number");
		if (address == null || address.length() > 30)
			throw new IllegalArgumentException("Invalid Address");
	
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	// Getters
	public String getContactId() { return contactId; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhoneNum() { return phoneNum; }
	public String getAddress() { return address; }
	
	// Setters
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("Invalid First Name");
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Invalid Last Name");
		this.lastName = lastName;
	}
	
	public void setPhoneNum(String phoneNum) {
		if (phoneNum == null || phoneNum.length() != 10)
			throw new IllegalArgumentException("Invalid Phone Number");
		this.phoneNum = phoneNum;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30)
			throw new IllegalArgumentException("Invalid Address");
		this.address = address;
	}
}
	
	
	
