package taskService;
//Requirments
public class Task {
	private final String taskId;
	private String name;
	private String description;
	// Constructor
	public Task(String taskId, String name, String description) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid Task Id");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// Getters
	public String getTaskId() {
		return taskId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	// Setters
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		this.name = name;
	}
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		this.description = description;
	}
}
