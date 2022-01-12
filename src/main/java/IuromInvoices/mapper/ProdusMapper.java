package IuromInvoices.mapper;

import IuromInvoices.dto.ProdusRequest;
import IuromInvoices.models.Produs;
import org.springframework.stereotype.Component;

@Component
public class ProdusMapper {

    public Produs produsRequestToProdus(ProdusRequest produsRequest) {
        return new Produs(produsRequest.getNume(), produsRequest.getPret(), produsRequest.getCantitate(),
                produsRequest.getUnitateMasura(), produsRequest.getDescriere());
    }

}
