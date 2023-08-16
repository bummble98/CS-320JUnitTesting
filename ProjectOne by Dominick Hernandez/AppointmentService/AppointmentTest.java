package projectOne;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
	protected String appointmentId, descriptionTest;
	protected String updatedDescription;
	protected Date dateTest, updatedDate, tooLateDate;
	protected String tooLongAppointmentId, tooLongDescription;
	
  @BeforeEach
  void testVariables() {
	  appointmentId = "CoolnewID1";
	  dateTest = java.sql.Date.valueOf(LocalDate.of(2115, Month.APRIL, 21));
	  descriptionTest = "An appointment that I need to go to";
	  updatedDate = java.sql.Date.valueOf(LocalDate.of(2114, Month.APRIL, 22));
	  updatedDescription = "An appointment that I forgor about";
	  tooLongAppointmentId = "86753098675309";
	  tooLateDate = java.sql.Date.valueOf(LocalDate.of(2015, Month.APRIL, 21));
	  tooLongDescription = "According to all known laws of aviation, there is no way that a bee should be able to fly. " +
	  "Its wings are too small to get its fat little body off the ground. The bee, of course, flies anyway. "
			  + "Because bees don’t care what humans think is impossible.”";
  }


  @Test
  void constructorTest() {
	  Appointment appointment = new Appointment(appointmentId, dateTest, descriptionTest);
	  assertAll("constructor",
			  () -> assertEquals(appointmentId, appointment.getID()),
              () -> assertEquals(dateTest, appointment.getDate()),
              () -> assertEquals(descriptionTest, appointment.getDescription()));
  }
  @Test
  void constructorTestIdNullFails() {
	  assertThrows(IllegalArgumentException.class,() -> new Appointment(null, dateTest, descriptionTest));
  }
  
  @Test
  void constructorTestIdTooLongFails() {
	  assertThrows(IllegalArgumentException.class,() -> new Appointment(tooLongAppointmentId, dateTest, descriptionTest));
  }
  
  @Test
  void setDateTest() {
	  Appointment appointment = new Appointment(appointmentId, dateTest, descriptionTest);
	  assertEquals(dateTest, appointment.getDate());
	  appointment.setDate(updatedDate);
	  assertEquals(updatedDate, appointment.getDate());
	  }
  
  @Test
  void setDateTestNullFails() {
	  Appointment appointment = new Appointment(appointmentId, dateTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class, () -> appointment.setDate(null));
	  }
  
  @Test
  void setDateTestTooLateFails() {
	  Appointment appointment = new Appointment(appointmentId, dateTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class,() -> appointment.setDate(tooLateDate));
	  }

  @Test
  void setDescriptionTest() {
	  Appointment appointment = new Appointment(appointmentId, dateTest, descriptionTest);
	  assertEquals(descriptionTest, appointment.getDescription());
	  appointment.setDescription(updatedDescription);
	  assertEquals(updatedDescription, appointment.getDescription());
  }
  
  @Test
  void setDescriptionTestNullFails() {
	  Appointment appointment = new Appointment(appointmentId, dateTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
  }
  
  @Test
  void setDescriptionTestTooLongFails() {
	  Appointment appointment = new Appointment(appointmentId, dateTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(tooLongDescription));
  }
}