package projectOne;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	protected String taskId, taskId2, nameTest, descriptionTest;
	protected String updatedName, updatedDescription;
	private TaskService taskService;
	
  @BeforeEach
  void testVariables() {
	  taskId = "CoolnewID1";
	  taskId2 = "CoolnewID2";
	  nameTest = "This is my new name";
	  descriptionTest = "A task that I should probably do";
	  updatedName = "new name ";
	  updatedDescription = "";
  }
  
  
  @Test
  void addTaskTest() {
	  taskService = new TaskService();
	  String taskID = taskService.addTask(new Task(taskId, nameTest, descriptionTest));
	  assertAll("add task",
			  () -> assertEquals(taskID, taskService.taskSearch(taskID).getID()),
              () -> assertEquals(nameTest, taskService.taskSearch(taskID).getName()),
              () -> assertEquals(descriptionTest, taskService.taskSearch(taskID).getDescription()));
  }
  
  
  @Test
  void deleteTaskTest() {
	  taskService = new TaskService();
	  String taskID = taskService.addTask(new Task(taskId, nameTest, descriptionTest));
	  String secondTaskID = taskService.addTask(new Task(taskId2, nameTest, descriptionTest));
	  taskService.deleteTask(taskID);
	  assertEquals(null, taskService.taskSearch(taskID));
	  taskService.deleteTask(secondTaskID);
	  assertThrows(IllegalArgumentException.class,() -> taskService.taskSearch(secondTaskID));
	  
  }
  

  @Test
  void updateTaskNameTest() {
	  taskService = new TaskService();
	  String taskID = taskService.addTask(new Task(taskId, nameTest, descriptionTest));
	  taskService.updateTaskName(taskId, updatedName);
	  assertEquals(updatedName, taskService.taskSearch(taskID).getName());
  }
  
  @Test
  void updateTaskDescrpitionTest() {
	  taskService = new TaskService();
	  String taskID = taskService.addTask(new Task(taskId, nameTest, descriptionTest));
	  taskService.updateTaskDescription(taskId, updatedDescription);
	  assertEquals(updatedDescription, taskService.taskSearch(taskID).getDescription());
  }
  
  @Test
  void doesTaskExistTest() {
	  taskService = new TaskService();
	  assertEquals(false, taskService.doesTaskExist(taskId));
	  taskService.addTask(new Task(taskId, nameTest, descriptionTest));
	  assertEquals(true, taskService.doesTaskExist(taskId));
  }
  
}