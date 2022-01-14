package IuromInvoices.services;

import IuromInvoices.dao.daoAbonament.AbonamentRepository;
import IuromInvoices.exception.AbonamentNotFoundException;
import IuromInvoices.models.Abonament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AbonamentService {

    private AbonamentRepository abonamentRepository;

    @Autowired
    public AbonamentService(AbonamentRepository abonamentRepository) {
        this.abonamentRepository = abonamentRepository;
    }

    public Abonament addAbonament(Abonament abonament) {
        return abonamentRepository.save(abonament);
    }

    public Abonament getAbonamentById(Long id) {
        Optional<Abonament> abonamentOptional = abonamentRepository.findById(id);
        if (abonamentOptional.isPresent()) {
            return abonamentOptional.get();
        } else {
            throw new AbonamentNotFoundException();
        }
    }
}
