package MidtermSprint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
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

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(taskList.isEmpty());

        taskList.addTask("Task1", "Description1");
        assertFalse(taskList.isEmpty());

        taskList.deleteFirstTask();
        assertTrue(taskList.isEmpty());
    }

    @Test
    public void testAddTask() {
        taskList.addTask("Task1", "Description1");
        assertFalse(taskList.isEmpty());

        taskList.addTask("Task2", "Description2");
        taskList.addTask("Task3", "Description3");

        outContent.reset();
        taskList.displayTasks();
        String output = outContent.toString();
        assertTrue(output.contains("Task1"));
        assertTrue(output.contains("Task2"));
        assertTrue(output.contains("Task3"));
    }

    @Test
    public void testDeleteFirstTask() {
        outContent.reset();
        taskList.deleteFirstTask();
        assertEquals("Task list is empty!\n", outContent.toString());

        taskList.addTask("Task1", "Description1");
        taskList.deleteFirstTask();
        assertTrue(taskList.isEmpty());

        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");
        outContent.reset();
        taskList.displayTasks();
        String beforeDelete = outContent.toString();
        assertTrue(beforeDelete.contains("Task1"));

        taskList.deleteFirstTask();
        outContent.reset();
        taskList.displayTasks();
        String afterDelete = outContent.toString();
        assertFalse(afterDelete.contains("Task1"));
        assertTrue(afterDelete.contains("Task2"));
    }

    @Test
    public void testDeleteLastTask() {
        outContent.reset();
        taskList.deleteLastTask();
        assertEquals("Task list is empty!\n", outContent.toString());

        taskList.addTask("Task1", "Description1");
        taskList.deleteLastTask();
        assertTrue(taskList.isEmpty());

        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");
        taskList.addTask("Task3", "Description3");

        taskList.deleteLastTask();
        outContent.reset();
        taskList.displayTasks();
        String output = outContent.toString();
        assertTrue(output.contains("Task1"));
        assertTrue(output.contains("Task2"));
        assertFalse(output.contains("Task3"));
    }

    @Test
    public void testDeleteTask() {
        outContent.reset();
        taskList.deleteTask("Task1");
        assertEquals("Task list is empty!\n", outContent.toString());

        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");
        taskList.addTask("Task3", "Description3");

        taskList.deleteTask("Task1");
        outContent.reset();
        taskList.displayTasks();
        String afterDeleteFirst = outContent.toString();
        assertFalse(afterDeleteFirst.contains("Task1"));
        assertTrue(afterDeleteFirst.contains("Task2"));

        taskList.addTask("Task4", "Description4");
        taskList.deleteTask("Task3");
        outContent.reset();
        taskList.displayTasks();
        String afterDeleteMiddle = outContent.toString();
        assertFalse(afterDeleteMiddle.contains("Task3"));
        assertTrue(afterDeleteMiddle.contains("Task2"));
        assertTrue(afterDeleteMiddle.contains("Task4"));

        outContent.reset();
        taskList.deleteTask("NonExistentTask");
        assertTrue(outContent.toString().contains("Task 'NonExistentTask' not found!"));
    }

    @Test
    public void testDisplayTasks() {
        outContent.reset();
        taskList.displayTasks();
        assertEquals("Task list is empty!\n", outContent.toString());

        taskList.addTask("Task1", "Description1");
        taskList.addTask("Task2", "Description2");

        outContent.reset();
        taskList.displayTasks();
        String output = outContent.toString();
        assertTrue(output.contains("Current Task List:"));
        assertTrue(output.contains("- Task1"));
        assertTrue(output.contains("- Task2"));
    }
}