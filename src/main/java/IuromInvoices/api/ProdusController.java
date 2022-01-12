package IuromInvoices.api;

import IuromInvoices.dto.ProdusRequest;
import IuromInvoices.mapper.ProdusMapper;
import IuromInvoices.models.Client;
import IuromInvoices.models.Produs;
import IuromInvoices.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/produs")
@RestController
@Validated
public class ProdusController {

    private final ProdusService produsService;
    private final ProdusMapper produsMapper;

    @Autowired
    public ProdusController(ProdusService produsService, ProdusMapper produsMapper) {
        this.produsService = produsService;
        this.produsMapper = produsMapper;
    }

    @PostMapping
    public ResponseEntity<Produs> addProdus(@Valid @NonNull @RequestBody ProdusRequest produsRequest) {

        Produs produs = produsMapper.produsRequestToProdus(produsRequest);
        Produs savedProdus = produsService.addProdus(produs);
        return ResponseEntity
                .created(URI.create("api/v1/produs" + savedProdus.getId()))
                .body(savedProdus);
    }

    @GetMapping
    public List<Produs> getAllProduse() {
        return produsService.getAllProduse();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Produs> getProdusById(@PathVariable("id")  UUID id)  {
        return ResponseEntity.ok().body(produsService.getProdusById(id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable("id")  UUID id) {
        var isRemoved = produsService.deleteProdus(id);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{id}")
    public Produs updateProdus(@PathVariable("id") UUID id,  @Valid @NonNull @RequestBody ProdusRequest produsRequest) {
        Produs produsToUpdate = produsMapper.produsRequestToProdus(produsRequest);
        return produsService.updateProdus(id,  produsToUpdate);
    }
}
