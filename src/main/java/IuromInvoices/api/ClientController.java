package IuromInvoices.api;

import IuromInvoices.dto.ClientRequest;
import IuromInvoices.mapper.ClientMapper;
import IuromInvoices.models.Client;
import IuromInvoices.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Void> deleteClient(@PathVariable("id") UUID id) {
        var isRemoved = clientService.deleteClient(id);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{id}")
    public Client updateClinet(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody ClientRequest clientToUpdateRequest) {
        Client clientToUpdate = clientMapper.clientRequestToClient(clientToUpdateRequest);
        return clientService.updateClient(id, clientToUpdate);
    }
}
