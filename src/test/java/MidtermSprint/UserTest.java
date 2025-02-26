package MidtermSprint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        user = new User("TestUser");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testUserCreation() {
        assertEquals("TestUser", user.getUsername());
        assertNotNull(user.getTaskList());
        assertEquals(0, user.getTaskCount());
    }

    @Test
    public void testEmptyUsernameValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("");
        });

        String expectedMessage = "Username cannot be empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testNullUsernameValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User(null);
        });

        String expectedMessage = "Username cannot be empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddTask() {
        user.addTask("Task1", "Description1");
        assertEquals(1, user.getTaskCount());

        user.addTask("Task2", "Description2");
        assertEquals(2, user.getTaskCount());
    }

    @Test
    public void testMarkTaskAsCompleted() {
        user.addTask("Task1", "Description1");

        user.markTaskAsCompleted("Task1");
        Task task = user.getTaskList().findTask("Task1");
        assertTrue(task.isComplete());
    }

    @Test
    public void testMarkTaskAsIncomplete() {
        user.addTask("Task1", "Description1");
        user.markTaskAsCompleted("Task1");

        user.markTaskAsIncomplete("Task1");
        Task task = user.getTaskList().findTask("Task1");
        assertFalse(task.isComplete());
    }

    @Test
    public void testDeleteTask() {
        user.addTask("Task1", "Description1");
        user.addTask("Task2", "Description2");

        user.deleteTask("Task1");
        assertEquals(1, user.getTaskCount());
        assertNull(user.getTaskList().findTask("Task1"));
    }

    @Test
    public void testToString() {
        assertEquals("TestUser (0 tasks)", user.toString());

        user.addTask("Task1", "Description1");
        assertEquals("TestUser (1 tasks)", user.toString());

        user.addTask("Task2", "Description2");
        assertEquals("TestUser (2 tasks)", user.toString());
    }
}