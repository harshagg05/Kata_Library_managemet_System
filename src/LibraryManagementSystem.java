import java.util.*;
public class LibraryManagementSystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    viewBooks();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        int bookId = Library.generateBookId();  // Generate unique ID for the book
        Book book = new Book(bookId, title, author);
        library.addBook(book);
    }

    private static void borrowBook() {
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();

        // Check if the book exists and is available
        if (library.isBookAvailable(title)) {
            Book book = library.findBookByTitle(title);
            book.borrowBook();
        } else {
            System.out.println("Either the book is not available in the library or it is already borrowed.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();

        Book book = library.findBookByTitle(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    private static void viewBooks() {
        library.viewBooks();
    }
}
