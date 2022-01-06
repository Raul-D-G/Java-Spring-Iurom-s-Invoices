package IuromInvoices.dao.daoProdus;

import IuromInvoices.models.Produs;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdusDao {

    int insertProdus(UUID id, Produs produs);

    default int insertProdus(Produs produs) {
        UUID id = UUID.randomUUID();
        return insertProdus(id, produs);
    }

    List<Produs> selectAllProduse();

    Optional<Produs> selectProdusById(UUID id);

    int deleteProdusById(UUID id);

    int updateProdusById(UUID id, Produs produs);
}
