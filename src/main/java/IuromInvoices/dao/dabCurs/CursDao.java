package IuromInvoices.dao.dabCurs;

import IuromInvoices.models.Curs;

import java.util.Optional;
import java.util.UUID;

public interface CursDao {

    Curs insertCurs(UUID id, Curs curs);

    default Curs insertCurs(Curs curs) {
        UUID id = UUID.randomUUID();
        return insertCurs(id, curs);
    }
    Optional<Curs> selectCursById(UUID id);
}
