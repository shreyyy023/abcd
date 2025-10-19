package PatronManager;

import java.util.ArrayList;
import java.util.List;

public class  Patron {
    private final int id;
    private String name;
    private List<Integer> borrowedBookISBNs;

    public Patron(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBookISBNs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getBorrowedBookISBNs() {
        return borrowedBookISBNs;
    }

    public void borrowBook(int isbn) {
        borrowedBookISBNs.add(isbn);
    }

    public void returnBook(int isbn) {
        borrowedBookISBNs.remove(Integer.valueOf(isbn));
    }
}
