package MidtermSprint;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Study", "Study for exams");
        assertEquals("Study", task.getName());
        assertEquals("Study for exams", task.getDescription());
        assertFalse(task.isComplete());
        assertNull(task.next);
    }

    @Test
    public void testTaskCompletion() {
        Task task = new Task("Study", "Study for exams");
        assertFalse(task.isComplete());

        task.setComplete(true);
        assertTrue(task.isComplete());

        task.setComplete(false);
        assertFalse(task.isComplete());
    }

    @Test
    public void testToString() {
        Task task = new Task("Study", "Study for exams");
        assertEquals("Study: Study for exams [ ] Pending", task.toString());

        task.setComplete(true);
        assertEquals("Study: Study for exams [✔ Completed]", task.toString());
    }

    @Test
    public void testEmptyNameValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("", "Empty name test");
        });

        String expectedMessage = "Task name cannot be empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testNullNameValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Null name test");
        });

        String expectedMessage = "Task name cannot be empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}