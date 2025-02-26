package MidtermSprint;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Display User Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    users.add(new User(username));
                    System.out.println("User '" + username + "' added!");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String userToFind = scanner.nextLine();
                    User foundUser = findUser(users, userToFind);

                    if (foundUser != null) {
                        System.out.print("Enter task name: ");
                        String taskName = scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String taskDescription = scanner.nextLine();
                        foundUser.getTaskList().addTask(taskName, taskDescription);
                        System.out.println("Task added to " + userToFind + "'s list.");
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    userToFind = scanner.nextLine();
                    foundUser = findUser(users, userToFind);

                    if (foundUser != null) {
                        System.out.print("Enter task name to mark as completed: ");
                        String completedTaskName = scanner.nextLine();
                        foundUser.getTaskList().markTaskAsCompleted(completedTaskName);
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter username: ");
                    userToFind = scanner.nextLine();
                    foundUser = findUser(users, userToFind);

                    if (foundUser != null) {
                        foundUser.getTaskList().displayTasks();
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static User findUser(ArrayList<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}
