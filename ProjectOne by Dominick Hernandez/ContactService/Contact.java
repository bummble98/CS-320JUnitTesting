package projectOne;
public class Contact {

	private String _ID;
	private String _firstName;
	private String _lastName;
	private String _phoneNumber;
	private String _address;
	
	public Contact(String id, String firstName, String lastName, String phoneNum, String address) {
		if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
		}
		else {
            this._ID = id; 
        }    

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNum);
		this.setAddress(address);
	}
	
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		_firstName = firstName;
	}
	
	public void setLastName (String lastName){
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		_lastName = lastName;
	}
	
	public void setPhoneNumber (String phoneNum) {
		if(phoneNum == null || phoneNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		int n = phoneNum.length();
		for (int i = 0; i < n; i++) {
            if (phoneNum.charAt(i) < '0'
                || phoneNum.charAt(i) > '9') {
            	throw new IllegalArgumentException("Invalid Phone Number");
            }
        }
		
		_phoneNumber = phoneNum;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		_address = address;
	}

	public String getID() {
		return _ID;
	}
	
	public String getFirstName() {
		return _firstName;
	}
	
	public String getLastName() {
		return _lastName;
	}
	
	public String getPhoneNumber() {
		return _phoneNumber;
	}
	
	public String getAddress() {
		return _address;
	}
}