package IuromInvoices.api;

import IuromInvoices.models.Produs;
import IuromInvoices.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/produs")
@RestController
public class ProdusController {

    private final ProdusService produsService;

    @Autowired
    public ProdusController(ProdusService produsService) {
        this.produsService = produsService;
    }

    @PostMapping
    public void addProdus(@Valid @NonNull @RequestBody Produs produs) {
        produsService.addProdus(produs);
    }

    @GetMapping
    public List<Produs> getAllProduse() {
        return produsService.getAllProduse();
    }

    @GetMapping(path = "{id}")
    public Produs getProdusById(@PathVariable("id")  UUID id)  {
        return produsService.getProdusById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProdus(@PathVariable("id")  UUID id) {
        produsService.deleteProdus(id);
    }

    @PutMapping(path = "{id}")
    public void updateProdus(@PathVariable("id") UUID id,  @Valid @NonNull  @RequestBody Produs produs) {
        produsService.updateProdus(id,  produs);
    }
}
