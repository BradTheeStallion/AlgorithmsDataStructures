package MidtermSprint;

public class Task {
    private String name;
    private String description;
    private boolean isComplete;
    Task next;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.isComplete = false;
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
}
