package PatronManager;

import interfaces.IPatronManager;
import java.util.ArrayList;
import java.util.List;

public class PatronManager implements IPatronManager {

    private List<Patron> patrons = new ArrayList<>();

    @Override
    public boolean addPatron(Patron patron) {
        for (Patron p : patrons) {
            if (p.getId() == patron.getId()) return false;
        }
        patrons.add(patron);
        return true;
    }

    @Override
    public boolean removePatron(int id) {
        return patrons.removeIf(p -> p.getId() == id);
    }

    @Override
    public boolean updatePatron(int id, String newName) {
        for (Patron p : patrons) {
            if (p.getId() == id) {
                p.setName(newName);
                return true;
            }
        }
        return false;
    }

    @Override
    public Patron getPatron(int id) {
        for (Patron p : patrons) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Patron> getAllPatrons() {
        return new ArrayList<>(patrons);
    }
}
