package MidtermSprint;

public class User {
    private String username;
    private TaskList taskList;

    public User(String username) {
        this.username = username;
        this.taskList = new TaskList();
    }

    public String getUsername() {
        return username;
    }

    public TaskList getTaskList() {
        return taskList;
    }
}
