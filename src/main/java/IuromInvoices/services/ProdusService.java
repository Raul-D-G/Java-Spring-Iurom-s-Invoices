package IuromInvoices.services;

import IuromInvoices.dao.daoProdus.ProdusDao;
import IuromInvoices.exception.ClientNotFoundException;
import IuromInvoices.exception.ProdusNotFoundException;
import IuromInvoices.models.Client;
import IuromInvoices.models.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdusService {

    private final ProdusDao produsDao;

    @Autowired
    public ProdusService(@Qualifier("postgresProdus") ProdusDao produsDao) {
        this.produsDao = produsDao;
    }

    public Produs addProdus(Produs produs) {
        return produsDao.insertProdus(produs);
    }

    public List<Produs> getAllProduse() {
        return produsDao.selectAllProduse();
    }

    public Produs getProdusById(UUID id) {
        Optional<Produs> produsOptional = produsDao.selectProdusById(id);

        if (produsOptional.isPresent()) {
            return produsOptional.get();
        } else {
            throw new ProdusNotFoundException();
        }
    }

    public boolean deleteProdus(UUID id) {
        return produsDao.deleteProdusById(id);
    }

    public Produs updateProdus(UUID id, Produs produs) {

        var updatedProdus = produsDao.updateProdusById(id, produs);
        if (updatedProdus ==  1) {
            return getProdusById(id);
        } else {
            throw new ClientNotFoundException();
        }
    }
}
