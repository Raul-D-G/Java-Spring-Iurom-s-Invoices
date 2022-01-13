package IuromInvoices.services;

import IuromInvoices.dao.daoAbonament.AbonamentDao;
import IuromInvoices.exception.AbonamentNotFoundException;
import IuromInvoices.models.Abonament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AbonamentService {

    private final AbonamentDao abonamentDao;

    @Autowired
    public AbonamentService(@Qualifier("postgresAbonament") AbonamentDao abonamentDao) {
        this.abonamentDao = abonamentDao;
    }

    public Abonament addAbonament(Abonament abonament) {
        return abonamentDao.insertAbonament(abonament);
    }

    public Abonament getAbonamentById(UUID id) {
        Optional<Abonament> abonamentOptional = abonamentDao.selectAbonamentById(id);
        if (abonamentOptional.isPresent()) {
            return abonamentOptional.get();
        } else {
            throw new AbonamentNotFoundException();
        }
    }
}
