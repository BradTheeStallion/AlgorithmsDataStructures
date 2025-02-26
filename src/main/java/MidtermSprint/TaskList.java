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
    public boolean isEmpty() {
        return head == null;
    }

    public void deleteFirstTask() {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }
        head = head.next;
    }

    public void deleteLastTask() {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Task current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void deleteTask(String name) {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        if (head.getName().equals(name)) {
            deleteFirstTask();
            return;
        }

        Task current = head;
        while (current.next != null && !current.next.getName().equals(name)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Task '" + name + "' not found!");
        }
    }

    public void displayTasks() {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        Task current = head;
        System.out.println("\nCurrent Task List:");
        while (current != null) {
            String status = current.isComplete() ? "[✔ Completed]" : "[ ] Pending";
            System.out.println("- " + current.getName() + ": " + current.getDescription() + " " + status);
            current = current.next;
        }
    }

    public void markTaskAsCompleted(String name) {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        Task current = head;
        while (current != null) {
            if (current.getName().equals(name)) {
                current.setComplete(true);
                System.out.println("Task '" + name + "' marked as completed!");
                return;
            }
            current = current.next;
        }
        System.out.println("Task '" + name + "' not found!");
    }
}