package IuromInvoices.mapper;

import IuromInvoices.dto.AbonamentRequest;
import IuromInvoices.models.Abonament;
import org.springframework.stereotype.Component;

@Component
public class AbonamentMapper {

    public Abonament abonamentRequestToAbonament(AbonamentRequest abonamentRequest) {
        return new Abonament(abonamentRequest.getNume(), abonamentRequest.getPret(),
                abonamentRequest.getValabilitate(), abonamentRequest.getLimitaFacturi());
    }

}
