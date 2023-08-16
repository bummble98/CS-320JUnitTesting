package projectOne;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
	protected String taskId, nameTest, descriptionTest;
	protected String updatedName, updatedDescription;
	protected String nullDescription, tooLongTaskId, tooLongName, tooLongDescription;
  @BeforeEach
  void testVariables() {
	  taskId = "CoolnewID1";
	  nameTest = "This is my new name";
	  descriptionTest = "A task that I should probably do";
	  updatedName = "My married name";
	  updatedDescription = "A task that I probably wont do";
	  tooLongTaskId = "86753098675309";
	  tooLongName = "This is my new name, it is mine and no one elses. I love my new name";
	  tooLongDescription = "I still havent done this task, why do I keep procrastinating. Alright, this is it."
    		+ "I am going to buckle down and do this. Let me just make some food first. Oh man thats alot of dishes."
    		+ "Okay first Im gonna wash the dishes, make some food, oh and the trash needs taken out, oh and also...";
  }


  @Test
  void constructorTest() {
	  Task task = new Task(taskId, nameTest, descriptionTest);
	  assertAll("constructor",
			  () -> assertEquals(taskId, task.getID()),
              () -> assertEquals(nameTest, task.getName()),
              () -> assertEquals(descriptionTest, task.getDescription()));
  }
  @Test
  void constructorTestIdNullFails() {
	  assertThrows(IllegalArgumentException.class,() -> new Task(null, nameTest, descriptionTest));
  }
  
  @Test
  void constructorTestIdTooLongFails() {
	  assertThrows(IllegalArgumentException.class,() -> new Task(tooLongTaskId, nameTest, descriptionTest));
  }
  
  @Test
  void setNameTest() {
	  Task task = new Task(taskId, nameTest, descriptionTest);
	  assertEquals(nameTest, task.getName());
	  task.setName(updatedName);
	  assertEquals(updatedName, task.getName());
	  }
  
  @Test
  void setNameTestNullFails() {
	  Task task = new Task(taskId, nameTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class, () -> task.setName(null));
	  }
  
  @Test
  void setNameTestTooLongFails() {
	  Task task = new Task(taskId, nameTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class,() -> task.setName(tooLongName));
	  }

  @Test
  void setDescriptionTest() {
	  Task task = new Task(taskId, nameTest, descriptionTest);
	  assertEquals(descriptionTest, task.getDescription());
	  task.setDescription(updatedDescription);
	  assertEquals(updatedDescription, task.getDescription());
  }
  
  @Test
  void setDescriptionTestNullFails() {
	  Task task = new Task(taskId, nameTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
  }
  
  @Test
  void setDescriptionTestTooLongFails() {
	  Task task = new Task(taskId, nameTest, descriptionTest);
	  assertThrows(IllegalArgumentException.class, () -> task.setDescription(tooLongDescription));
  }
}