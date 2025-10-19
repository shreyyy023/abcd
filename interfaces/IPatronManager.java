package interfaces;

import PatronManager.Patron;

import java.util.List;

public interface IPatronManager {
    boolean addPatron(Patron patron);
    boolean removePatron(int id);
    boolean updatePatron(int id, String newName);
    Patron getPatron(int id);
    List<Patron> getAllPatrons();
}
