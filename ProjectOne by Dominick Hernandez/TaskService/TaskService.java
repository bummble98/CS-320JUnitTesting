package projectOne;
import java.util.Vector;
public class TaskService {

	private Vector<Task> _taskList = new Vector<Task>();
	
	public Task taskSearch(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(_taskList.isEmpty()) {
			throw new IllegalArgumentException("No tasks in list");
		}
		
		for (Task task : _taskList) {
			if (task.getID() == id) {
				 return task;
			}
		}
		return null;			
	}
	
	public boolean doesTaskExist(String id) {
        try {
            Task result = taskSearch(id);
            return result != null;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
	
	public String addTask(Task task) {
		
		if (doesTaskExist(task.getID())) {
			throw new IllegalArgumentException("Duplicate task ID");
		}
		
		_taskList.add(task);
		return task.getID();
	}
	
	public void deleteTask(String id) {
		Task taskToDelete = taskSearch(id);
	    if (taskToDelete != null) {
	        _taskList.remove(taskToDelete);
	    } else {
			throw new IllegalArgumentException("Contact Does Not Exist");
	    }
	}
	
	public void updateTaskName(String id, String name) {
		Task taskToUpdate = taskSearch(id);
		taskToUpdate.setName(name);
				
	}
	
	public void updateTaskDescription(String id, String description) {
		Task taskToUpdate = taskSearch(id);
		taskToUpdate.setDescription(description);
				
	}
}