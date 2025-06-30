package taskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	
	private TaskService service;

	@BeforeEach
	void setup() {
		service = new TaskService();
	}
	// Test to delete task
	@Test
	void testAddAndDeleteTask() {
		Task task = new Task("123457", "Testing", "Test test");
		service.addTask(task);
		assertThrows(IllegalArgumentException.class,()-> service.addTask(new Task("123457","Name", "Testing")));
		service.deleteTask("123457");
		assertThrows(IllegalArgumentException.class,()-> service.deleteTask("123457"));

	}
	//Test task update
	@Test
	void testUpdateTask() {
		Task task = new Task("222222", "Name", "Description");
		service.addTask(task);
		service.updateName("222222", "New Name");
		service.updateDescription("222222", "New Description");
		assertEquals("New Name", task.getName());
		assertEquals("New Description", task.getDescription());

	}

}
