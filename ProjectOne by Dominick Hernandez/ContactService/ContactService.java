package projectOne;
import java.util.Vector;
public class ContactService {

	private Vector<Contact> _contactList = new Vector<Contact>();
	
	public String addContact(Contact contact) {
		if (doesContactExist(contact.getID())) {
			throw new IllegalArgumentException("Duplicate Contact ID");
		}
		_contactList.add(contact);
		return contact.getID();
	}
	
	
	public Contact contactSearch(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(_contactList.isEmpty()) {
			throw new IllegalArgumentException("No contacts in list");
		}
		
		for (Contact contact : _contactList) {
			if (contact.getID() == id) {
				 return contact;
			}
		}
		return null;			
	}
	
	public boolean doesContactExist(String id) {
        try {
            Contact result = contactSearch(id);
            return result != null;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
	
	public void deleteContact(String id) {
	    Contact contactToDelete = contactSearch(id);
	    if (contactToDelete != null) {
	        _contactList.remove(contactToDelete);
	    } else {
			throw new IllegalArgumentException("Contact Does Not Exist");
	    }
	}
	
	
	public void updateContactFirstName(String id, String firstName) {
		Contact contactToUpdate = contactSearch(id);
		contactToUpdate.setFirstName(firstName);
				
	}
	
	
	public void updateContactLastName(String id, String lastName) {
		Contact contactToUpdate = contactSearch(id);
		contactToUpdate.setLastName(lastName);
				
	}
	
	
	public void updateContactPhoneNumber(String id, String phoneNumber) {
		Contact contactToUpdate = contactSearch(id);
		contactToUpdate.setPhoneNumber(phoneNumber);
				
	}
	
	
	public void updateContactAddress(String id, String address) {
		Contact contactToUpdate = contactSearch(id);
		contactToUpdate.setAddress(address);
				
	}
	
	
	
	
}