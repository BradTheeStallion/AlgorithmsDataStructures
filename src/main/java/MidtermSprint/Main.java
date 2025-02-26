package MidtermSprint;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean useSampleData = askYesNo("Would you like to load sample data (y/n)? ");

        if (useSampleData) {
            loadSampleData();
        }

        while (true) {
            displayMenu();
            int choice = getValidIntInput("Choose an option: ", 1, 8);

            switch (choice) {
                case 1:
                    addUser();
                    break;

                case 2:
                    addTaskToUser();
                    break;

                case 3:
                    markTaskStatus(true);
                    break;

                case 4:
                    markTaskStatus(false);
                    break;

                case 5:
                    deleteTask();
                    break;

                case 6:
                    displayUserTasks();
                    break;

                case 7:
                    displayAllUsers();
                    break;

                case 8:
                    exitProgram();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== TO-DO LIST MANAGER =====");
        System.out.println("1. Add User");
        System.out.println("2. Add Task to User");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Mark Task as Incomplete");
        System.out.println("5. Delete Task");
        System.out.println("6. Display User Tasks");
        System.out.println("7. Display All Users");
        System.out.println("8. Exit");
    }

    private static void addUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println("Username cannot be empty. Try again.");
            return;
        }

        if (findUser(users, username) != null) {
            System.out.println("User '" + username + "' already exists!");
            return;
        }

        users.add(new User(username));
        System.out.println("User '" + username + "' added successfully!");
    }

    private static void addTaskToUser() {
        if (users.isEmpty()) {
            System.out.println("No users exist. Please add a user first.");
            return;
        }

        User user = selectUser();
        if (user == null) return;

        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine().trim();

        if (taskName.isEmpty()) {
            System.out.println("Task name cannot be empty. Try again.");
            return;
        }

        System.out.print("Enter task description: ");
        String taskDescription = scanner.nextLine();

        user.addTask(taskName, taskDescription);
    }

    private static void markTaskStatus(boolean completed) {
        if (users.isEmpty()) {
            System.out.println("No users exist. Please add a user first.");
            return;
        }

        User user = selectUser();
        if (user == null) return;

        if (user.getTaskList().isEmpty()) {
            System.out.println("User has no tasks. Please add tasks first.");
            return;
        }

        user.displayTasks();

        System.out.print("Enter task name to mark as " + (completed ? "completed" : "incomplete") + ": ");
        String taskName = scanner.nextLine();

        if (completed) {
            user.markTaskAsCompleted(taskName);
        } else {
            user.markTaskAsIncomplete(taskName);
        }
    }

    private static void deleteTask() {
        if (users.isEmpty()) {
            System.out.println("No users exist. Please add a user first.");
            return;
        }

        User user = selectUser();
        if (user == null) return;

        if (user.getTaskList().isEmpty()) {
            System.out.println("User has no tasks. Please add tasks first.");
            return;
        }

        user.displayTasks();

        System.out.print("Enter task name to delete: ");
        String taskName = scanner.nextLine();

        user.deleteTask(taskName);
    }

    private static void displayUserTasks() {
        if (users.isEmpty()) {
            System.out.println("No users exist. Please add a user first.");
            return;
        }

        User user = selectUser();
        if (user == null) return;

        user.displayTasks();
    }

    private static void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users exist. Please add a user first.");
            return;
        }

        System.out.println("\n===== ALL USERS =====");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println((i + 1) + ". " + user.toString());
        }
    }

    private static User selectUser() {
        displayAllUsers();

        int userIndex = getValidIntInput("Select user (enter number): ", 1, users.size()) - 1;
        return users.get(userIndex);
    }

    private static void exitProgram() {
        System.out.println("Thank you for using the To-Do List Manager!");
        scanner.close();
    }

    private static User findUser(ArrayList<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    private static int getValidIntInput(String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                System.out.print(prompt);
                scanner.next();
            }
            input = scanner.nextInt();
            scanner.nextLine();

            if (input < min || input > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            }
        } while (input < min || input > max);

        return input;
    }

    private static boolean askYesNo(String prompt) {
        System.out.print(prompt);
        String response = scanner.nextLine().trim().toLowerCase();
        return response.startsWith("y");
    }

    private static void loadSampleData() {
        User alice = new User("Alice");
        User bob = new User("Bob");

        alice.addTask("Grocery Shopping", "Buy milk, eggs, and bread");
        alice.addTask("Study Java", "Complete chapter 7 exercises");
        alice.addTask("Call Mom", "Discuss weekend plans");
        alice.markTaskAsCompleted("Grocery Shopping");

        bob.addTask("Fix Bug", "Debug the login module");
        bob.addTask("Team Meeting", "Prepare project update slides");
        bob.addTask("Gym", "Leg day workout");
        bob.markTaskAsCompleted("Team Meeting");

        users.add(alice);
        users.add(bob);

        System.out.println("Sample data loaded successfully!");
    }
}