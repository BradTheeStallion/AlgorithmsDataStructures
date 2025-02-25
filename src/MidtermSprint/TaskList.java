package MidtermSprint;

public class TaskList {
    private Task head;

    public TaskList() {
        head = null;
    }

    public void addTask(String name, String description) {
        Task newTask = new Task(name, description);

        if (head == null) {
            head = newTask;
            return;
        }

        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newTask;
    }
}
