package IuromInvoices.api;


import IuromInvoices.dto.AbonamentRequest;
import IuromInvoices.mapper.AbonamentMapper;
import IuromInvoices.models.Abonament;
import IuromInvoices.services.AbonamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("api/v1/abonament")
@RestController
@Validated
public class AbonamentController {

    private final AbonamentService abonamentService;
    private final AbonamentMapper abonamentMapper;

    @Autowired
    public AbonamentController(AbonamentService abonamentService, AbonamentMapper abonamentMapper) {
        this.abonamentService = abonamentService;
        this.abonamentMapper = abonamentMapper;
    }

    @PostMapping
    public ResponseEntity<Abonament> addAbonament(@Valid @NonNull @RequestBody AbonamentRequest abonamentRequest) {
        Abonament abonament = abonamentMapper.abonamentRequestToAbonament(abonamentRequest);
        Abonament savedAbonament = abonamentService.addAbonament(abonament);
        return ResponseEntity
                .created(URI.create("/api/v1/abonament/" + savedAbonament.getId()))
                .body(savedAbonament);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Abonament> getAbonamentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(abonamentService.getAbonamentById(id));
    }
}
