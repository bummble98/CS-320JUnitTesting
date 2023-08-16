package projectOne;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
	protected String appointmentId, appointmentId2, descriptionTest;
	protected String updatedDescription;
	protected Date dateTest, updatedDate;
	private AppointmentService appointmentService;
	
  @BeforeEach
  void testVariables() {
	  appointmentId = "CoolnewID1";
	  appointmentId2 = "CoolnewID2";
	  dateTest = java.sql.Date.valueOf(LocalDate.of(2115, Month.APRIL, 21));
	  descriptionTest = "A appointment that I should probably do";
	  updatedDate = java.sql.Date.valueOf(LocalDate.of(2125, Month.APRIL, 21));
	  updatedDescription = "";
  }
  
  
  @Test
  void addAppointmentTest() {
	  appointmentService = new AppointmentService();
	  
	  String appointmentID = appointmentService.addAppointment(new Appointment(appointmentId, dateTest, descriptionTest));
	  assertAll("add appointment",
			  () -> assertEquals(appointmentID, appointmentService.appointmentSearch(appointmentID).getID()),
              () -> assertEquals(dateTest, appointmentService.appointmentSearch(appointmentID).getDate()),
              () -> assertEquals(descriptionTest, appointmentService.appointmentSearch(appointmentID).getDescription()));
  }
  
  @Test
  void deleteAppointmentTest() {
	  appointmentService = new AppointmentService();
	  String appointmentID = appointmentService.addAppointment(new Appointment(appointmentId, dateTest, descriptionTest));
	  String secondAppointmentID = appointmentService.addAppointment(new Appointment(appointmentId2, dateTest, descriptionTest));
	  appointmentService.deleteAppointment(appointmentID);
	  assertEquals(null, appointmentService.appointmentSearch(appointmentID));
	  appointmentService.deleteAppointment(secondAppointmentID);
	  assertThrows(IllegalArgumentException.class,() -> appointmentService.appointmentSearch(secondAppointmentID));
	  
  }
  

  @Test
  void updateAppointmentDateTest() {
	  appointmentService = new AppointmentService();
	  String appointmentID = appointmentService.addAppointment(new Appointment(appointmentId, dateTest, descriptionTest));
	  appointmentService.updateAppointmentDate(appointmentId, updatedDate);
	  assertEquals(updatedDate, appointmentService.appointmentSearch(appointmentID).getDate());
  }
  
  @Test
  void updateAppointmentDescrpitionTest() {
	  appointmentService = new AppointmentService();
	  String appointmentID = appointmentService.addAppointment(new Appointment(appointmentId, dateTest, descriptionTest));
	  appointmentService.updateAppointmentDescription(appointmentId, updatedDescription);
	  assertEquals(updatedDescription, appointmentService.appointmentSearch(appointmentID).getDescription());
  }
  
  @Test
  void doesAppointmentExistTest() {
	  appointmentService = new AppointmentService();
	  assertEquals(false, appointmentService.doesAppointmentExist(appointmentId));
	  appointmentService.addAppointment(new Appointment(appointmentId, dateTest, descriptionTest));
	  assertEquals(true, appointmentService.doesAppointmentExist(appointmentId));
  }
  
}