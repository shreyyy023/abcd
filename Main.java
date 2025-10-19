import BookManager.BookManager;
import BookManager.Book;
import Library.Library;
import PatronManager.PatronManager;
import PatronManager.Patron;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Initialize managers and library
        BookManager bookManager = new BookManager();
        PatronManager patronManager = new PatronManager();
        Library library = new Library(bookManager, patronManager);

        // Add books
        Book[] books = {
                new Book("Harry Potter", "J.K. Rowling", 123, 1997),
                new Book("The Hobbit", "J.R.R. Tolkien", 456, 1937),
                new Book("1984", "George Orwell", 789, 1949),
                new Book("The Catcher in the Rye", "J.D. Salinger", 101, 1951),
                new Book("To Kill a Mockingbird", "Harper Lee", 102, 1960),
                new Book("Pride and Prejudice", "Jane Austen", 103, 1813),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 104, 1925),
                new Book("Moby Dick", "Herman Melville", 105, 1851),
                new Book("War and Peace", "Leo Tolstoy", 106, 1869),
                new Book("The Lord of the Rings", "J.R.R. Tolkien", 107, 1954),
                new Book("Animal Farm", "George Orwell", 108, 1945),
                new Book("Jane Eyre", "Charlotte Bronte", 109, 1847),
                new Book("Brave New World", "Aldous Huxley", 110, 1932),
                new Book("The Alchemist", "Paulo Coelho", 111, 1988),
                new Book("The Da Vinci Code", "Dan Brown", 112, 2003)
        };

        System.out.println("Adding books:");
        for (Book b : books) System.out.println(bookManager.addBook(b));

        // Add patrons
        Patron[] patrons = {
                new Patron(1, "Alice"),
                new Patron(2, "Bob"),
                new Patron(3, "Charlie"),
                new Patron(4, "Diana"),
                new Patron(5, "Eve")
        };
        for (Patron p : patrons) patronManager.addPatron(p);

        // Borrow some books
        library.borrowBook(1, 123); // Alice -> Harry Potter
        library.borrowBook(2, 789); // Bob -> 1984
        library.borrowBook(3, 101); // Charlie -> Catcher in the Rye

        // Print all books
        library.printAllBooks();

        // Print only available books
        library.printAvailableBooks();

        // Print patron status
        library.printPatronStatus();

        // Return some books
        library.returnBook(1, 123); // Alice returns Harry Potter
        library.returnBook(3, 101); // Charlie returns Catcher in the Rye

        System.out.println("\nAfter returns:");

        // Print updated status
        library.printAllBooks();
        library.printAvailableBooks();
        library.printPatronStatus();
    }
}
