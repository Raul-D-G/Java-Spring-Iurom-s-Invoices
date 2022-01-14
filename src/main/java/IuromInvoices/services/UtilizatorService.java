package IuromInvoices.services;

import IuromInvoices.dao.daoUtilizator.UtilizatorRepository;
import IuromInvoices.exception.UtilizatorNotFoundException;
import IuromInvoices.models.Utilizator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilizatorService {

    private UtilizatorRepository utilizatorRepository;

    public UtilizatorService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }


    public Utilizator addUtilizator(Utilizator utilizator) {
        return utilizatorRepository.save(utilizator);
    }

    public Utilizator getUtilizatorById(Long id) {
        Optional<Utilizator> utilizatorOptional = utilizatorRepository.findById(id);
        if (utilizatorOptional.isPresent()) {
            return utilizatorOptional.get();
        }
        throw new UtilizatorNotFoundException();
    }
}
