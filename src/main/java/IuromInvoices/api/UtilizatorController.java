package IuromInvoices.api;

import IuromInvoices.dto.UtilizatorRequest;
import IuromInvoices.mapper.UtilizatorMapper;
import IuromInvoices.models.Utilizator;
import IuromInvoices.services.UtilizatorService;
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

@RequestMapping("api/v1/utilizator")
@RestController
@Validated
public class UtilizatorController {

    private final UtilizatorService utilizatorService;
    private final UtilizatorMapper utilizatorMapper;

    @Autowired
    public UtilizatorController(UtilizatorService utilizatorService, UtilizatorMapper utilizatorMapper) {
        this.utilizatorService = utilizatorService;
        this.utilizatorMapper = utilizatorMapper;
    }

    @Operation(summary = "Adaugare utilizator", description = "Adauga un nou utilizator in baza de date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Au fost creat o noua entitate de utilizator",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Utilizator.class))}),
            @ApiResponse(responseCode = "500",  description = "Utilizatorul nu a fost salvat",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Id-ul utilizatorului sau corpul cererii sunt gresite",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<Utilizator> addUtilizator(@Valid @NotNull @RequestBody UtilizatorRequest utilizatorRequest) {
        Utilizator utilizator = utilizatorMapper.utilizatorRequestToUtilizator(utilizatorRequest);
        Utilizator savedUtilizator = utilizatorService.addUtilizator(utilizator);
        return ResponseEntity
                .created(URI.create("/api/v1/utilizator/" + savedUtilizator.getId()))
                .body(savedUtilizator);
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
