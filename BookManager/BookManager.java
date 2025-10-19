package BookManager;

import interfaces.IBookManager;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookManager implements IBookManager {

    private final List<Book> books = new ArrayList<>();

    @Override
    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getISBN() == book.getISBN()) {
                return false;
            }
        }
        books.add(book);
        return true;
    }

    @Override
    public boolean removeBook(int ISBN) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getISBN()== ISBN) {
                books.remove(b);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean updateBook(int ISBN, Book updatedBook) {
        for(Book b :books){
            if (b.getISBN()==ISBN){
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                b.setPublicationYear(updatedBook.getPublicationYear());
                return true;

            }
        }
        return false;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
    @Override
    public Book searchByISBN(int isbn) {
        for (Book b : books) {
            if (b.getISBN() == isbn) {
                return b;
            }
        }
        return null; // not found
    }


    @Override
    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book b : books) {
            if (b.isAvailable()) {
                available.add(b);
            }
        }
        return available;
    }



}
