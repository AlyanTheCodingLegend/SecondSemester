// Custom exception for attempting to borrow a book that is not available
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Custom exception for attempting to return a book that was not borrowed
class BookNotBorrowedException extends Exception {
    public BookNotBorrowedException(String message) {
        super(message);
    }
}

// Custom exception for input validation errors
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class Book {
    private String title;
    private String isbn;
    private boolean available;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() throws BookNotAvailableException {
        if (!available) {
            throw new BookNotAvailableException("Book is not available for borrowing.");
        }
        available = false;
    }
    public void returnBook() throws BookNotBorrowedException {
        if (available) {
            throw new BookNotBorrowedException("Book was not borrowed.");
        }
        available = true;
    }
}

class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }
    public void borrowBook(String isbn) throws BookNotAvailableException, InvalidInputException {
        if (isbn == null || isbn.isEmpty() || isbn.length() != 13) {
            System.out.println(isbn.length());
            throw new InvalidInputException("ISBN cannot be null or empty and must be 13 digits long.");
        }

        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                book.borrow();
                return;
            }
        }

        throw new BookNotAvailableException("Book with ISBN " + isbn + " is not available in the inventory.");
    }
    public void returnBook(String isbn) throws BookNotBorrowedException, InvalidInputException {
        if (isbn == null || isbn.isEmpty() || isbn.length() != 13) {
            throw new InvalidInputException("ISBN cannot be null or empty and must be 13 digits long.");
        }

        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                book.returnBook();
                return;
            }
        }
        throw new BookNotBorrowedException("Book with ISBN " + isbn + " was not borrowed.");
    }
}

public class LibraryTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Java Programming", "1234567890123"),
            new Book("Python Programming", "09876543213256")
        };

        Library library = new Library(books);

        try {
            library.borrowBook("1234567890123");
            System.out.println("Book borrowed successfully.");
        } catch (BookNotAvailableException | InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            library.borrowBook("1111111111111"); // Trying to borrow a non-existent book
        } catch (BookNotAvailableException | InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
