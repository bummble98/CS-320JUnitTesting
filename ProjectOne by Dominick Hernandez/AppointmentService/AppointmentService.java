package projectOne;
import java.util.Date;
import java.util.Vector;
public class AppointmentService {

	private Vector<Appointment> _appointmentList = new Vector<Appointment>();
	
	public Appointment appointmentSearch(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(_appointmentList.isEmpty()) {
			throw new IllegalArgumentException("No appointments in list");
		}
		
		for (Appointment appointment : _appointmentList) {
			if (appointment.getID() == id) {
				 return appointment;
			}
		}
		return null;			
	}
	
	public boolean doesAppointmentExist(String id) {
        try {
            Appointment result = appointmentSearch(id);
            return result != null;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
	
	public String addAppointment(Appointment appointment) {
		
		if (doesAppointmentExist(appointment.getID())) {
			throw new IllegalArgumentException("Duplicate appointment ID");
		}
		
		_appointmentList.add(appointment);
		return appointment.getID();
	}
	
	public void deleteAppointment(String id) {
		Appointment appointmentToDelete = appointmentSearch(id);
	    if (appointmentToDelete != null) {
	        _appointmentList.remove(appointmentToDelete);
	    } else {
			throw new IllegalArgumentException("Contact Does Not Exist");
	    }
	}
	
	public void updateAppointmentDate(String id, Date date) {
		Appointment appointmentToUpdate = appointmentSearch(id);
		appointmentToUpdate.setDate(date);
				
	}
	
	public void updateAppointmentDescription(String id, String description) {
		Appointment appointmentToUpdate = appointmentSearch(id);
		appointmentToUpdate.setDescription(description);
				
	}
}