import java.util.ArrayList;
import java.util.Scanner;

//Simulate a movie theater that helps users to book and reserve seats.
//reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
//cancel seats
//retrieve initial seating charting

public class MovieTheater {
    private int rows;
    private int seatsPerRow;
    private ArrayList<String> reservedSeats;

    public MovieTheater(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.reservedSeats = new ArrayList<>();
    }

    public boolean reserveSeat(int row, int seatNumber) {
        if (row < 0 || row >= rows || seatNumber < 0 || seatNumber >= seatsPerRow) {
            System.out.println("Invalid seat selection.");
            return false;
        }

        String seatId = row + ":" + seatNumber;

        if (reservedSeats.contains(seatId)) {
            System.out.println("Seat is already taken. Available seats:");
            printAvailableSeats();
            return false;
        }

        reservedSeats.add(seatId);
        System.out.println("Seat reserved successfully: Row " + row + ", Seat " + seatNumber);
        return true;
    }

    public boolean cancelSeat(int row, int seatNumber) {
        if (row < 0 || row >= rows || seatNumber < 0 || seatNumber >= seatsPerRow) {
            System.out.println("Invalid seat selection.");
            return false;
        }

        String seatId = row + ":" + seatNumber;

        if (reservedSeats.remove(seatId)) {
            System.out.println("Seat canceled: Row " + row + ", Seat " + seatNumber);
            return true;
        }

        System.out.println("Seat is not reserved.");
        return false;
    }

    public void printSeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < seatsPerRow; j++) {
                String seatId = i + ":" + j;
                System.out.print(reservedSeats.contains(seatId) ? "[X] " : "[O] ");
            }
            System.out.println();
        }
    }

    public void printAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                String seatId = i + ":" + j;
                if (!reservedSeats.contains(seatId)) {
                    System.out.println("Row " + i + ", Seat " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTheater theater = new MovieTheater(5, 5);
        boolean running = true;

        System.out.println("Welcome to the Movie Theater Reservation System!");

        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. View seating chart");
            System.out.println("4. View available seats");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter row number: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter seat number: ");
                    int seat = scanner.nextInt();
                    theater.reserveSeat(row, seat);
                }
                case 2 -> {
                    System.out.print("Enter row number: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter seat number: ");
                    int seat = scanner.nextInt();
                    theater.cancelSeat(row, seat);
                }
                case 3 -> theater.printSeatingChart();
                case 4 -> theater.printAvailableSeats();
                case 5 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}