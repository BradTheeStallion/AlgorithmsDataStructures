package LinkedListTask1;

public class Main {
    public static void main(String[] args) {
        ReadingList myList = new ReadingList();

        myList.addBook("The Great Gatsby");
        myList.addBook("1984");
        myList.addBook("To Kill a Mockingbird");
        myList.addBook("Pride and Prejudice");

        myList.displayBooks();

        myList.deleteFirstBook();
        System.out.println("\nAfter deleting first book:");
        myList.displayBooks();

        myList.deleteLastBook();
        System.out.println("\nAfter deleting last book:");
        myList.displayBooks();

        myList.deleteBook("1984");
        System.out.println("\nAfter deleting '1984':");
        myList.displayBooks();
    }
}