package IuromInvoices.mapper;

import IuromInvoices.dto.ClientRequest;
import IuromInvoices.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client clientRequestToClient(ClientRequest clientRequest) {
        return new Client(clientRequest.getNume(), clientRequest.getCui(), clientRequest.getAdresa(),
                clientRequest.getNrCont());
    }

}