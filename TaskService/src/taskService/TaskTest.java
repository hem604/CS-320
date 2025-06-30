package taskService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {
	// Test task
	@Test
	void testTask() {
		Task task = new Task("123456", "Task Name", "Lets test this task.");
		assertTrue(task.getTaskId().equals("123456"));
		assertTrue(task.getName().equals("Task Name"));
		assertTrue(task.getDescription().equals("Lets test this task."));
	}
	//Test if ID is null or too long
	@Test
	void testInvalidId() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task(null, "Test Name", "Lets test this task.");
		});
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("123456789012", "Test Name", "Lets test this task.");
		});
	}
	//Test if Name is null or too long
	@Test
	void testInvalidName() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("123456", null, "Lets test this task.");
		});
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("123456", "TestASuuuuupppppeeerrrLongName", "Lets test this task.");
		});
	}
	//Test if Description is null or too long
	@Test
	void testInvalidDescription() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("123456", "Test Name", null);
		});
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("123456", "Test Name", "Lets test suuuuuuuuuuuuppppppeeeeerrrrrrrrr loooonnngggggggggg long task.");
		});
	}
	//Test to update Name
	@Test
	public void testUpdateName() {
		Task task = new Task("123456", "Test Name", "Lets test this");
		task.setName("Hana");
		assertEquals("Hana", task.getName());
	}
	//Test to invalid Name change 
	@Test
	public void testUpdateNameChange() {
		Task task = new Task("098765", "Name", "Description");
		assertThrows(IllegalArgumentException.class,()-> task.setName(null));
		assertThrows(IllegalArgumentException.class,()-> task.setName("TestASuuuuupppppeeerrrLongName"));
	}
	//Test to update Description
	@Test
	public void testUpdateDescription() {
		Task task = new Task("123456", "Test Name", "Lets test this");
		task.setDescription("A very nice test.");
		assertEquals("A very nice test.", task.getDescription());
	}
}
