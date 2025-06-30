package taskService;

import java.util.ArrayList;


// Store contacts in an Array List
public class TaskService {
	private ArrayList<Task> tasks;
	
	public TaskService() {
		tasks = new ArrayList<>();
	}
	
	// Add unique task ID
	public void addTask(Task task) {
		if (getTasksId(task.getTaskId()) != null) {
			throw new IllegalArgumentException("Task ID Already Exists");
		}
		tasks.add(task);
	}
	// Delete Task by ID
	public void deleteTask(String taskId) {
		Task task = getTasksId(taskId);
		if (task == null) {
			throw new IllegalArgumentException("Task Not Found");
		}
		tasks.remove(task);
	}
	// Update name by ID
	public void updateName(String taskId, String newName) {
		Task task = getTasksId(taskId);
		if (task == null) {
			throw new IllegalArgumentException("Task Not Found");
		}
		task.setName(newName);
	}	
	// Update description
	public void updateDescription(String taskId, String newDescription) {
		Task task = getTasksId(taskId);
		if (task == null) {
			throw new IllegalArgumentException("Task Not Found");
		}
		task.setDescription(newDescription);
	}	
	// Helper
	private Task getTasksId(String taskID) {
		for (Task task : tasks) {
			if (task.getTaskId().equals(taskID)) {
				return task;
			}	
		}
		return null;
	}
}

