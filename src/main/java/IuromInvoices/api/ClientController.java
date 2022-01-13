package IuromInvoices.api;

import IuromInvoices.dto.ClientRequest;
import IuromInvoices.exception.ClientNotFoundException;
import IuromInvoices.mapper.ClientMapper;
import IuromInvoices.models.Client;
import IuromInvoices.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @Operation(summary = "Adaugare client", description = "Adauga un nou client in baza de date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Au fost creat o noua entitate de client",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "500",  description = "Clientul nu a fost salvat",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Id-ul clientului sau corpul cererii sunt gresite",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<Client> addClient(@Valid @NonNull @RequestBody ClientRequest clientRequest) {
        Client client = clientMapper.clientRequestToClient(clientRequest);
        Client savedClient = clientService.addClient(client);
        return ResponseEntity
                .created(URI.create("/api/v1/client/" + savedClient.getId()))
                .body(savedClient);
    }

    @Operation(summary = "Obtinere clienti", description = "Obtine lista cu toti clientii")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Au fost gasiti clienti in baza de date",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "404",  description = "Nu au fost gasiti clienti",
                content = @Content)})
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @Operation(summary = "Cauta un anume client", description = "Cauta clientul cu un id specific")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientul a fost gasit",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "404",  description = "Nu au fost gasiti clientul",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Id-ul clientului este gresit",
                    content = @Content)})
    @GetMapping(path = "{id}")
    public ResponseEntity<Client> getClientById(@Parameter(description = "id-ul clientului cautat")
                                                @PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @Operation(summary = "Modifica un anume client", description = "Modifica clientul cu un id specific")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientul a fost modificat",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "400", description = "Id-ul clientului este gresit",
                    content = @Content)})
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteClient(@Parameter(description = "id-ul clientului dorit sters")
                                             @PathVariable("id") UUID id) {
        var isRemoved = clientService.deleteClient(id);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Modifica un anume client", description = "Modifica clientul cu un id specific")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientul a fost modificat",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "500",  description = "Nu au fost gasiti clientul",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Id-ul sau corpul cererii sunt gresite",
                    content = @Content)})
    @PutMapping(path = "{id}")
    public Client updateClient(@Parameter(description = "id-ul clientului modificat")
                               @PathVariable("id") UUID id,
                               @Valid @NonNull @RequestBody ClientRequest clientToUpdateRequest) {
        Client clientToUpdate = clientMapper.clientRequestToClient(clientToUpdateRequest);
        return clientService.updateClient(id, clientToUpdate);
    }
}
