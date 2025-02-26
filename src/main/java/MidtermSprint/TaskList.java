package MidtermSprint;

public class TaskList {
    private Task head;
    private int size;

    public TaskList() {
        head = null;
        size = 0;
    }

    public void addTask(String name, String description) {
        Task newTask = new Task(name, description);

        if (head == null) {
            head = newTask;
            size++;
            return;
        }

        if (findTask(name) != null) {
            System.out.println("Task '" + name + "' already exists!");
            return;
        }

        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newTask;
        size++;
    }

    public int getSize() {
        return size;
    }

    public Task findTask(String name) {
        Task current = head;
        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
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
        size--;
    }

    public void deleteLastTask() {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Task current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void deleteTask(String name) {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        if (head.getName().equalsIgnoreCase(name)) {
            deleteFirstTask();
            return;
        }

        Task current = head;
        while (current.next != null && !current.next.getName().equalsIgnoreCase(name)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            System.out.println("Task '" + name + "' deleted successfully!");
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
        System.out.println("\nCurrent Task List (" + size + " tasks):");
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.toString());
            current = current.next;
            count++;
        }
    }

    public void markTaskAsCompleted(String name) {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        Task task = findTask(name);
        if (task != null) {
            if (task.isComplete()) {
                System.out.println("Task '" + name + "' is already completed!");
            } else {
                task.setComplete(true);
                System.out.println("Task '" + name + "' marked as completed!");
            }
        } else {
            System.out.println("Task '" + name + "' not found!");
        }
    }

    public void markTaskAsIncomplete(String name) {
        if (isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }

        Task task = findTask(name);
        if (task != null) {
            if (!task.isComplete()) {
                System.out.println("Task '" + name + "' is already pending!");
            } else {
                task.setComplete(false);
                System.out.println("Task '" + name + "' marked as pending!");
            }
        } else {
            System.out.println("Task '" + name + "' not found!");
        }
    }
}