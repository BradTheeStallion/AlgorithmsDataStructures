package MidtermSprint;

public class User {
    private String username;
    private TaskList taskList;

    public User(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
        this.taskList = new TaskList();
    }

    public String getUsername() {
        return username;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void addTask(String name, String description) {
        taskList.addTask(name, description);
    }

    public void markTaskAsCompleted(String name) {
        taskList.markTaskAsCompleted(name);
    }

    public void markTaskAsIncomplete(String name) {
        taskList.markTaskAsIncomplete(name);
    }

    public void deleteTask(String name) {
        taskList.deleteTask(name);
    }

    public void displayTasks() {
        System.out.println("\n===== " + username + "'s Tasks =====");
        taskList.displayTasks();
    }

    public int getTaskCount() {
        return taskList.getSize();
    }

    @Override
    public String toString() {
        return username + " (" + getTaskCount() + " tasks)";
    }
}