import java.util.Scanner;
import java.util.InputMismatchException;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        double[] temperature = null;

        while (temperature == null) {
            try {
                System.out.print("Enter the number of days (positive number): ");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Error: Please enter a positive number.");
                    scanner.nextLine();
                    continue;
                }
                temperature = new double[n];
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer number.");
                scanner.nextLine();
            } catch (NegativeArraySizeException e) {
                System.out.println("Error: Array size cannot be negative.");
                scanner.nextLine();
            }
        }

        double total = 0;

        for (int i = 0; i < temperature.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter temperature for day " + (i + 1) + ": ");
                    temperature[i] = scanner.nextDouble();
                    total += temperature[i];
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid temperature number.");
                    scanner.nextLine();
                }
            }
        }

        double average = total / temperature.length;
        System.out.printf("Average Temperature = %.2f%n", average);

        int count = 0;
        for (double temp : temperature) {
            if (temp > average) {
                count++;
            }
        }

        if (count == 1) {
            System.out.println(count + " day was above average temperature.");
        } else
            System.out.println(count + " days were above average temperature.");

        scanner.close();
    }
}