public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;  // Initially, the book is not borrowed
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("The book '" + title + "' is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You have returned: " + title);
        } else {
            System.out.println("This book wasn't borrowed.");
        }
    }

    public void viewBook() {
        String status = isBorrowed ? "Borrowed" : "Available";
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + " - Status: " + status);
    }
}
