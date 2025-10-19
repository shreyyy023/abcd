package Library;

import BookManager.Book;
import BookManager.BookManager;
import PatronManager.Patron;
import PatronManager.PatronManager;

import java.util.List;

public class Library {

    private BookManager bookManager;
    private PatronManager patronManager;

    public Library(BookManager bookManager, PatronManager patronManager) {
        this.bookManager = bookManager;
        this.patronManager = patronManager;
    }

    // Borrow a book
    public boolean borrowBook(int patronId, int isbn) {
        Patron patron = patronManager.getPatron(patronId);
        Book book = bookManager.searchByISBN(isbn);
        if (patron == null) {
            System.out.println("Patron not found.");
            return false;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return false;
        }
        book.setAvailable(false);
        patron.borrowBook(isbn);
        System.out.println(patron.getName() + " borrowed \"" + book.getTitle() + "\" successfully.");
        return true;
    }

    // Return a book
    public boolean returnBook(int patronId, int isbn) {
        Patron patron = patronManager.getPatron(patronId);
        Book book = bookManager.searchByISBN(isbn);
        if (patron == null) {
            System.out.println("Patron not found.");
            return false;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (!patron.getBorrowedBookISBNs().contains(isbn)) {
            System.out.println(patron.getName() + " did not borrow this book.");
            return false;
        }
        book.setAvailable(true);
        patron.returnBook(isbn);
        System.out.println(patron.getName() + " returned \"" + book.getTitle() + "\" successfully.");
        return true;
    }
    public void printAvailableBooks() {
        List<Book> available = bookManager.getAvailableBooks();
        System.out.println("\nAvailable books in the library:");
        System.out.printf("%-25s %-20s %-10s %-5s\n", "Title", "Author", "ISBN", "Year");
        System.out.println("-------------------------------------------------------------");
        for (Book b : available) {
            System.out.printf("%-25s %-20s %-10d %-5d\n",
                    b.getTitle(),
                    b.getAuthor(),
                    b.getISBN(),
                    b.getPublicationYear());
        }
    }


    // Print all books
    public void printAllBooks() {
        System.out.println("\nAll books in the library:");
        System.out.printf("%-25s %-20s %-10s %-5s %-10s\n", "Title", "Author", "ISBN", "Year", "Available");
        System.out.println("---------------------------------------------------------------");
        for (Book b : bookManager.getAllBooks()) {
            System.out.printf("%-25s %-20s %-10d %-5d %-10s\n",
                    b.getTitle(),
                    b.getAuthor(),
                    b.getISBN(),
                    b.getPublicationYear(),
                    b.isAvailable() ? "Yes" : "No");
        }
    }

    // Print all patrons
    public void printAllPatrons() {
        System.out.println("\nAll patrons:");
        for (Patron p : patronManager.getAllPatrons()) {
            System.out.println(p.getId() + ": " + p.getName() + " | Borrowed: " + p.getBorrowedBookISBNs());
        }
    }
    public void printPatronStatus() {
        List<Patron> patrons = patronManager.getAllPatrons();
        System.out.println("\nAll patrons:");
        for (Patron p : patrons) {
            System.out.println(p.getId() + ": " + p.getName() + " | Borrowed: " + p.getBorrowedBookISBNs());
        }
    }


    public void printLibraryStatus() {
        printAllBooks();
        printAllPatrons();
    }
}
