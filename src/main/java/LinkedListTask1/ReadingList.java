package LinkedListTask1;

public class ReadingList {
    private Book head;

    public ReadingList() {
        head = null;
    }

    public void addBook(String title) {
        Book newBook = new Book(title);

        if (head == null) {
            head = newBook;
            return;
        }

        Book current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newBook;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void deleteFirstBook() {
        if (isEmpty()) {
            System.out.println("Reading list is empty!");
            return;
        }
        head = head.next;
    }

    public void deleteLastBook() {
        if (isEmpty()) {
            System.out.println("Reading list is empty!");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Book current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void deleteBook(String title) {
        if (isEmpty()) {
            System.out.println("Reading list is empty!");
            return;
        }

        if (head.title.equals(title)) {
            deleteFirstBook();
            return;
        }

        Book current = head;
        while (current.next != null && !current.next.title.equals(title)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Book '" + title + "' not found!");
        }
    }

    public void displayBooks() {
        if (isEmpty()) {
            System.out.println("Reading list is empty!");
            return;
        }

        Book current = head;
        System.out.println("\nCurrent Reading List:");
        while (current != null) {
            System.out.println("- " + current.title);
            current = current.next;
        }
    }
}