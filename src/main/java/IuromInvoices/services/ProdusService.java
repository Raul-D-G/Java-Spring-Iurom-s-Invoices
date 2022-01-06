package IuromInvoices.services;

import IuromInvoices.dao.daoProdus.ProdusDao;
import IuromInvoices.models.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdusService {

    private final ProdusDao produsDao;

    @Autowired
    public ProdusService(ProdusDao produsDao) {
        this.produsDao = produsDao;
    }

    public int addProdus(Produs produs) {
        return produsDao.insertProdus(produs);
    }

    public List<Produs> getAllProduse() {
        return produsDao.selectAllProduse();
    }

    public Optional<Produs> getProdusById(UUID id) {
        return produsDao.selectProdusById(id);
    }

    public int deleteProdus(UUID id) {
        return produsDao.deleteProdusById(id);
    }

    public int updateProdus(UUID id, Produs produs) {
        return produsDao.updateProdusById(id, produs);
    }
}
