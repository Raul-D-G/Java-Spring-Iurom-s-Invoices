package IuromInvoices.mapper;

import IuromInvoices.dto.UtilizatorRequest;
import IuromInvoices.models.Utilizator;
import org.springframework.stereotype.Component;

@Component
public class UtilizatorMapper {

    public Utilizator utilizatorRequestToUtilizator(UtilizatorRequest utilizatorRequest) {
        return new Utilizator(utilizatorRequest.getNume(), utilizatorRequest.getMail(), utilizatorRequest.getCui(),
                utilizatorRequest.getAdresa(), utilizatorRequest.getNrCont(), utilizatorRequest.getIdAbonament());
    }

}
