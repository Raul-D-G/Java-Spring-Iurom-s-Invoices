package IuromInvoices.services;

import IuromInvoices.dao.dabCurs.CursDao;
import IuromInvoices.exception.CursNotFoundException;
import IuromInvoices.models.Curs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CursService {

    private final CursDao cursDao;

    @Autowired
    public CursService(@Qualifier("postgresCurs") CursDao cursDao) {
        this.cursDao = cursDao;
    }

    public Curs addCurs(Curs curs) {
         return cursDao.insertCurs(curs);
    }

    public Curs getCursById(UUID id) {
        Optional<Curs> cursOptional =  cursDao.selectCursById(id);
        if (cursOptional.isPresent()) {
            return cursOptional.get();
        }
        throw new CursNotFoundException();
    }
}
