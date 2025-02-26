package MidtermSprint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    private TaskList taskList;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddTask() {
        assertTrue(taskList.isEmpty());
        assertEquals(0, taskList.getSize());

        taskList.addTask("Task1", "Description1");
        assertFalse(taskList.isEmpty());
        assertEquals(1, taskList.getSize());

        taskList.addTask("Task2", "Description2");
        assertEquals(2, taskList.getSize());
    }

    @Test
    public void testAddDuplicateTask() {
        taskList.addTask("Task1", "Description1");
        outContent.reset();

        taskList.addTask("Task1", "New Description");
        assertTrue(outContent.toString().contains("Task 'Task1' already exists!"));
        assertEquals(1, taskList.getSize());
    }

    @Test
    public void testFindTask() {
        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");

        Task found = taskList.findTask("Task1");
        assertNotNull(found);
        assertEquals("Task1", found.getName());

        found = taskList.findTask("NonExistent");
        assertNull(found);

        found = taskList.findTask("tAsK1");
        assertNotNull(found);
        assertEquals("Task1", found.getName());
    }

    @Test
    public void testDeleteFirstTask() {
        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");

        taskList.deleteFirstTask();
        assertEquals(1, taskList.getSize());
        assertNull(taskList.findTask("Task1"));
        assertNotNull(taskList.findTask("Task2"));
    }

    @Test
    public void testDeleteLastTask() {
        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");

        taskList.deleteLastTask();
        assertEquals(1, taskList.getSize());
        assertNotNull(taskList.findTask("Task1"));
        assertNull(taskList.findTask("Task2"));
    }

    @Test
    public void testDeleteSpecificTask() {
        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");
        taskList.addTask("Task3", "Description3");

        taskList.deleteTask("Task2");
        assertEquals(2, taskList.getSize());
        assertNotNull(taskList.findTask("Task1"));
        assertNull(taskList.findTask("Task2"));
        assertNotNull(taskList.findTask("Task3"));
    }

    @Test
    public void testMarkTaskAsCompleted() {
        taskList.addTask("Task1", "Description1");

        taskList.markTaskAsCompleted("Task1");
        Task task = taskList.findTask("Task1");
        assertTrue(task.isComplete());

        outContent.reset();
        taskList.markTaskAsCompleted("Task1");
        assertTrue(outContent.toString().contains("Task 'Task1' is already completed!"));
    }

    @Test
    public void testMarkTaskAsIncomplete() {
        taskList.addTask("Task1", "Description1");
        taskList.markTaskAsCompleted("Task1");

        taskList.markTaskAsIncomplete("Task1");
        Task task = taskList.findTask("Task1");
        assertFalse(task.isComplete());

        outContent.reset();
        taskList.markTaskAsIncomplete("Task1");
        assertTrue(outContent.toString().contains("Task 'Task1' is already pending!"));
    }

    @Test
    public void testEmptyListOperations() {
        taskList.deleteFirstTask();
        assertTrue(outContent.toString().contains("Task list is empty!"));
        outContent.reset();

        taskList.deleteLastTask();
        assertTrue(outContent.toString().contains("Task list is empty!"));
        outContent.reset();

        taskList.deleteTask("Any");
        assertTrue(outContent.toString().contains("Task list is empty!"));
        outContent.reset();

        taskList.markTaskAsCompleted("Any");
        assertTrue(outContent.toString().contains("Task list is empty!"));
        outContent.reset();

        taskList.markTaskAsIncomplete("Any");
        assertTrue(outContent.toString().contains("Task list is empty!"));
    }
}