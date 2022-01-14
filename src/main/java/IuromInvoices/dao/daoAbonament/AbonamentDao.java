package IuromInvoices.dao.daoAbonament;

import IuromInvoices.models.Abonament;

import java.util.Optional;
import java.util.UUID;

public interface AbonamentDao {

    Abonament insertAbonament(Long id, Abonament abonament);

    default Abonament insertAbonament(Abonament abonament) {
//        UUID id = UUID.randomUUID();
        long id = 1;
        return insertAbonament(id, abonament);
    }

    Optional<Abonament> selectAbonamentById(Long id);
}
