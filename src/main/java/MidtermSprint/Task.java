package MidtermSprint;

public class Task {
    private String name;
    private String description;
    private boolean isComplete;
    Task next;

    public Task(String name, String description) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        this.name = name;
        this.description = description;
        this.isComplete = false;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        String status = isComplete ? "[✔ Completed]" : "[ ] Pending";
        return name + ": " + description + " " + status;
    }
}