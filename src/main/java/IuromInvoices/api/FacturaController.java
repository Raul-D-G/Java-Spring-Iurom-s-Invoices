package IuromInvoices.api;

import IuromInvoices.dto.FacturaRequest;
import IuromInvoices.mapper.FacturaMapper;
import IuromInvoices.models.*;
import IuromInvoices.services.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RequestMapping("api/v1/factura")
@RestController
@Validated
public class FacturaController {

    private final FacturaService facturaService;
    private final FacturaMapper facturaMapper;
    private final UtilizatorService utilizatorService;
    private final ClientService clientService;
    private final ProdusService produsService;
    private final CursService cursService;

    @Autowired
    public FacturaController(FacturaService facturaService, FacturaMapper facturaMapper, UtilizatorService utilizatorService, ClientService clientService, ProdusService produsService, CursService cursService) {
        this.facturaService = facturaService;
        this.facturaMapper = facturaMapper;
        this.utilizatorService = utilizatorService;
        this.clientService = clientService;
        this.produsService = produsService;
        this.cursService = cursService;
    }

    @Operation(summary = "Adaugare factura", description = "Adauga o noua factura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Au fost creat o noua entitate de tip factura",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Factura.class))}),
            @ApiResponse(responseCode = "500",  description = "Factura nu a fost salvat",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Corpul cererii este gresit",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<Factura> addFactura(@Valid @NotNull @RequestBody FacturaRequest facturaRequest) {
        Factura factura = facturaMapper.facturaRequestToFactura(facturaRequest);

        Utilizator utilizator = utilizatorService.getUtilizatorById(factura.getIdUtilizator());
        Client client = clientService.getClientById(factura.getIdClient());
        Produs produs = produsService.getProdusById(factura.getIdProdus());
        Curs curs = cursService.getCursById(factura.getIdCurs());

        factura.setUtilizator(utilizator);
        factura.setClient(client);
        factura.setProdus(produs);
        factura.setCurs(curs);

        Factura savedFactura = facturaService.addFactura(factura);
        return ResponseEntity
                .created(URI.create("/api/v1/factura/" + savedFactura.getId()))
                .body(savedFactura);
    }

    @Operation(summary = "Cauta un anume utilizator", description = "Cauta utilizator cu un id specific")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilizatorul a fost gasit",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Utilizator.class))}),
            @ApiResponse(responseCode = "404",  description = "Nu au fost gasiti utilizatorul",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Id-ul utilizatorului este gresit",
                    content = @Content)})
    @GetMapping(path = "{id}")
    public ResponseEntity<Utilizator> getUtilizatorById(@Parameter(description = "id-ul utilizatorului cautat")
                                                        @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(utilizatorService.getUtilizatorById(id));
    }

}
