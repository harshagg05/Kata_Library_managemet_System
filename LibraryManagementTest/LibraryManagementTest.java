import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagementTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        // Initialize a new library and books for each test
        library = new Library();
        book1 = new Book(BookManager.generateBookId(), "EatThatFrog", "Brain Tracy");
        book2 = new Book(BookManager.generateBookId(), "The White Tiger", "Adiga");
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    void testAddBook() {
        // Test that books are correctly added to the library
        assertEquals(2, library.getBooks().size());
        assertTrue(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
    }

    @Test
    void testBorrowBook() {
        // Test borrowing an available book
        book1.borrowBook();
        assertTrue(book1.isBorrowed());

        // Try borrowing the same book again, it should fail
        book1.borrowBook();
        assertTrue(book1.isBorrowed());
    }

    @Test
    void testReturnBook() {
        // Borrow and return a book
        book1.borrowBook();
        assertTrue(book1.isBorrowed());

        book1.returnBook();
        assertFalse(book1.isBorrowed());
    }

    @Test
    void testViewBooks() {
        // Ensure viewBooks displays correct information for both books
        library.viewBooks();  // This is a console output, not an assertable behavior in a test case

        // Manually test the status
        assertEquals(2, library.getBooks().size());
        assertFalse(book1.isBorrowed());
        assertFalse(book2.isBorrowed());
    }

    @Test
    void testCheckBookAvailability() {
        // Ensure book availability check works
        assertTrue(library.isBookAvailable("EatThatFrog"));
        assertTrue(library.isBookAvailable("The White Tiger"));

        // Borrow one book
        book1.borrowBook();

        // After borrowing, check availability
        assertFalse(library.isBookAvailable("EatThatFrog"));
        assertTrue(library.isBookAvailable("The White Tiger"));
    }

    @Test
    void testFindBookByTitle() {
        // Test finding a book by its title
        Book foundBook = library.findBookByTitle("EatThatFrog");
        assertNotNull(foundBook);
        assertEquals("EatThatFrog", foundBook.getTitle());

        // Test for a non-existing book
        Book notFoundBook = library.findBookByTitle("Unknown Book");
        assertNull(notFoundBook);
    }

    @Test
    void testBookManagerGeneratesUniqueIds() {
        // Test that BookManager generates unique IDs for each book
        Book newBook1 = BookManager.createBook("Book1", "Author1");
        Book newBook2 = BookManager.createBook("Book2", "Author2");

        assertNotEquals(newBook1.getId(), newBook2.getId());
    }
}
