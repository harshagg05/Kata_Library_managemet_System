import java.util.*;

class Library {
        private List<Book> books;
        private static int nextId = 1;  // Static variable to assign unique IDs

        public Library() {
            books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book '" + book.getTitle() + "' added to the library with ID: " + book.getId());
        }

        public void viewBooks() {
            if (books.isEmpty()) {
                System.out.println("No books in the library.");
            } else {
                System.out.println("Books in the library:");
                for (Book book : books) {
                    book.viewBook();
                }
            }
        }

        public Book findBookByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }

        public boolean isBookAvailable(String title) {
            Book book = findBookByTitle(title);
            return book != null && !book.isBorrowed();
        }

        // Generate unique ID for each book
        public static int generateBookId() {
            return nextId++;
        }
    }

