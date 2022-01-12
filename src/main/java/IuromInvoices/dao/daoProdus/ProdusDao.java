package IuromInvoices.dao.daoProdus;

import IuromInvoices.models.Produs;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdusDao {

    Produs insertProdus(UUID id, Produs produs);

    default Produs insertProdus(Produs produs) {
        UUID id = UUID.randomUUID();
        return insertProdus(id, produs);
    }

    List<Produs> selectAllProduse();

    Optional<Produs> selectProdusById(UUID id);

    boolean deleteProdusById(UUID id);

    int updateProdusById(UUID id, Produs produs);
}
