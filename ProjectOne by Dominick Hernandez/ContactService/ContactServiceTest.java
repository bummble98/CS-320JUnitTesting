package projectOne;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	protected String contactId, contactId2, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String updatedFirstName, updatedLastName, updatedPhoneNumber, updatedAddress;
	private ContactService contactService;

  @BeforeEach
  void testVariables() {
	  contactId = "CoolnewID1";
	  contactId2 = "CoolnewID2";
	  firstNameTest = "Dom";
	  lastNameTest = "Hernandez";
	  phoneNumberTest = "1234567890";
	  addressTest = "That place around the corner";
	  updatedFirstName = "Domi";
	  updatedLastName = "SecondName";
	  updatedPhoneNumber = "8675309999";
	  updatedAddress = "Updated Address";
  }
  
  
  @Test
  void addContactTest() {
	  contactService = new ContactService();
	  String contactID = contactService.addContact(new Contact (contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  assertAll("add contact",
			  () -> assertEquals(contactID, contactService.contactSearch(contactID).getID()));
  }
  
  
  @Test
  void deleteContactTest() {
	  contactService = new ContactService();
	  String contactID = contactService.addContact(new Contact (contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  contactService.deleteContact(contactID);
	  String secondContactID = contactService.addContact(new Contact (contactId2, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  assertEquals(null, contactService.contactSearch(contactID));
	  contactService.deleteContact(secondContactID);
	  assertThrows(IllegalArgumentException.class,() -> contactService.contactSearch(secondContactID));
	  
  }
  

  @Test
  void updateContactFirstNameTest() {
	  contactService = new ContactService();
	  String contactID = contactService.addContact(new Contact (contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  contactService.contactSearch(contactID).setFirstName(updatedFirstName);
	  assertEquals(updatedFirstName, contactService.contactSearch(contactID).getFirstName());
  }
  
  
  @Test
  void updateContactLastNameTest() {
	  contactService = new ContactService();
	  String contactID = contactService.addContact(new Contact (contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  contactService.contactSearch(contactID).setLastName(updatedLastName);
	  assertEquals(updatedLastName, contactService.contactSearch(contactID).getLastName());
  }
  
  
  @Test
  void updateContactPhoneNumTest() {
	  contactService = new ContactService();
	  String contactID = contactService.addContact(new Contact (contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  contactService.contactSearch(contactID).setPhoneNumber(updatedPhoneNumber);
	  assertEquals(updatedPhoneNumber, contactService.contactSearch(contactID).getPhoneNumber());
  }
  
  
  @Test
  void updateContactAddressTest() {
	  contactService = new ContactService();
	  String contactID = contactService.addContact(new Contact (contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  contactService.contactSearch(contactID).setAddress(updatedAddress);
	  assertEquals(updatedAddress, contactService.contactSearch(contactID).getAddress());
  }
  
  
  @Test
  void doesContactExistTest() {
	  contactService = new ContactService();
	  assertEquals(false, contactService.doesContactExist(contactId));
	  contactService.addContact(new Contact (contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
	  assertEquals(true, contactService.doesContactExist(contactId));
  }
  
}