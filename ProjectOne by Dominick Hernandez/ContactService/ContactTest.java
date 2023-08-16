package projectOne;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String updatedFirstName, updatedLastName, updatedPhoneNumber, updatedAddress;
	protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void testVariables() {
    contactId = "CoolnewID1";
    firstNameTest = "Dom";
    lastNameTest = "Hernandez";
    phoneNumberTest = "1234567890";
    addressTest = "That place around the corner";
    updatedFirstName = "Spongebob";
    updatedLastName = "Squarepant";
    updatedPhoneNumber = "1234567291";
    updatedAddress = "That new place around here";
    tooLongContactId = "86753098675309";
    tooLongFirstName = "This Name Is Way Too Long";
    tooLongLastName = "And So Is This One";
    tooLongPhoneNumber = "86753099999";
    tooShortPhoneNumber = "8675309";
    tooLongAddress = "Far Far Away, So Far, Like Past The Mountains Or Something";
  }


  @Test
  void constructorTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertAll("constructor",
			  () -> assertEquals(contactId, contact.getID()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
	  }

  @Test
  void addContactTestNullIdFails() {
	  assertThrows(IllegalArgumentException.class,() -> new Contact (null, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
  }
  
  @Test
  void addContactTestTooLongIdFails() {
	  assertThrows(IllegalArgumentException.class,() -> new Contact (tooLongContactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest));
  }
  

  @Test
  void setFirstNameTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertEquals(firstNameTest, contact.getFirstName());
	  contact.setFirstName(updatedFirstName);
	  assertEquals(updatedFirstName, contact.getFirstName());
  }
  
  
  @Test
  void setFirstNameNullFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
  }

  
  @Test
  void setFirstNameTooLongFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(tooLongFirstName));
  }

  
  @Test
  void setLastNameTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertEquals(lastNameTest, contact.getLastName());
	  contact.setLastName(updatedLastName);
	  assertEquals(updatedLastName, contact.getLastName());
  }
  
  
  @Test
  void setLastNameNullFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
  }
  
  
  @Test
  void setLastNameTooLongFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class, () -> contact.setLastName(tooLongFirstName));
  }
  

  @Test
  void setPhoneNumberTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertEquals(phoneNumberTest, contact.getPhoneNumber());
	  contact.setPhoneNumber(updatedPhoneNumber);
	  assertEquals(updatedPhoneNumber, contact.getPhoneNumber());
			  
  }
  
  
  @Test
  void setPhoneNumberNullFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class,() -> contact.setPhoneNumber(null));
  }
  
  
  @Test
  void setPhoneNumberTooShortFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows( IllegalArgumentException.class, () -> contact.setPhoneNumber(tooShortPhoneNumber));
  }

  
  @Test
  void setPhoneNumberTooLongFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows( IllegalArgumentException.class, () -> contact.setPhoneNumber(tooLongPhoneNumber));
  }
  
  
  @Test
  void setPhoneNumberNonNumberFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(contactId));
  }
  
  
  @Test
  void setAddressTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertEquals(addressTest, contact.getAddress());
	  contact.setAddress(updatedAddress);
	  assertEquals(updatedAddress, contact.getAddress());
  }
  
  
  @Test
  void setAddressNullFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
  }
  
  
  @Test
  void setAddressTooLongFailsTest() {
	  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	  assertThrows(IllegalArgumentException.class, () -> contact.setAddress(tooLongAddress));
  }
}