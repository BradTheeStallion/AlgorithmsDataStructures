import java.util.ArrayList;

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
        MovieTheater theater = new MovieTheater(5, 10);

        theater.reserveSeat(2, 5);
        theater.reserveSeat(2, 5);
        theater.printSeatingChart();
        theater.cancelSeat(2, 5);
        theater.printSeatingChart();
    }
}