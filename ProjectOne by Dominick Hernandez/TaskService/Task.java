package projectOne;
public class Task {

	private String _ID;
	private String _name;
	private String _description;
	
	public Task(String id, String name, String description) {
		if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
		}
		else {
            this._ID = id; 
        }    

		this.setName(name);
		this.setDescription(description);
	}
	
	public void setName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		_name = name;
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
	
	public String getName() {
		return _name;
	}
	
	public String getDescription() {
		return _description;
	}
}
	