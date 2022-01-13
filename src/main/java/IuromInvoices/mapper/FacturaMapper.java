package IuromInvoices.mapper;

import IuromInvoices.dto.FacturaRequest;
import IuromInvoices.models.Factura;
import org.springframework.stereotype.Component;

@Component
public class FacturaMapper {

    public Factura facturaRequestToFactura(FacturaRequest facturaRequest) {
        return new Factura(facturaRequest.getSerie(), facturaRequest.getNr(), facturaRequest.getDataEmitere(),
                facturaRequest.getTermenPlata(), facturaRequest.getDelegat(), facturaRequest.getTva(),
                facturaRequest.getIdUtilizator(), facturaRequest.getIdClient(), facturaRequest.getIdProdus(),
                facturaRequest.getIdCurs());
    }

}
