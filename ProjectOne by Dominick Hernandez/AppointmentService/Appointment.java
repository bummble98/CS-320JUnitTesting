package projectOne;

import java.util.Date;

public class Appointment {

	private String _ID;
	private Date _date;
	private String _description;
	
	public Appointment(String id, Date date, String description) {
		if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
		}
		else {
            this._ID = id; 
        }    

		this.setDate(date);
		this.setDescription(description);
	}
	
	public void setDate(Date date) {
		if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		_date = date;
	}
	
	public void setDescription (String description){
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		_description = description;
	}

	public String getID() {
		return _ID;
	}
	
	public Date getDate() {
		return _date;
	}
	
	public String getDescription() {
		return _description;
	}
}
	