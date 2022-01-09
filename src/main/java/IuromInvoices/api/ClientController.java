package IuromInvoices.api;

import IuromInvoices.dto.ClientRequest;
import IuromInvoices.mapper.ClientMapper;
import IuromInvoices.models.Client;
import IuromInvoices.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/client")
@RestController
@Validated
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@Valid @NonNull @RequestBody ClientRequest clientRequest) {
        Client client = clientMapper.clientRequestToClient(clientRequest);
        Client savedClient = clientService.addClient(client);
        return ResponseEntity
                .created(URI.create("/api/v1/client/" + savedClient.getId()))
                .body(savedClient);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @DeleteMapping(path = "{id}")
    public void deleteClient(@PathVariable("id") UUID id) {
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{id}")
    public void updateClinet(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Client clientToUpdate) {
        clientService.updateClient(id, clientToUpdate);
    }
}
