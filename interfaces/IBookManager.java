package interfaces;
import BookManager.Book;

import java.util.List;


public interface IBookManager {
    boolean addBook(Book book);
    boolean removeBook(int ISBN);
    boolean updateBook(int ISBN,Book updatedBook);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    Book searchByISBN(int isbn);
    List<Book> getAllBooks();
    List<Book> getAvailableBooks();

}
