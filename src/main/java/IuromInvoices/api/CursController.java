package IuromInvoices.api;

import IuromInvoices.dto.CursRequest;
import IuromInvoices.mapper.CursMapper;
import IuromInvoices.models.Curs;
import IuromInvoices.services.CursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.UUID;

@RequestMapping("api/v1/curs")
@RestController
@Validated
public class CursController {

    private final CursService cursService;
    private final CursMapper cursMapper;

    @Autowired
    public CursController(CursService cursService, CursMapper cursMapper) {
        this.cursService = cursService;
        this.cursMapper = cursMapper;
    }

    @PostMapping
    public ResponseEntity<Curs> addCurs(@Valid  @NotNull @RequestBody CursRequest cursRequest) {
        Curs curs = cursMapper.cursRequestToCurs(cursRequest);
        Curs savedCurs = cursService.addCurs(curs);
        return ResponseEntity
                .created(URI.create("/api/v1/curs/" + savedCurs.getId()))
                .body(savedCurs);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Curs> getCursById(@PathVariable("id") UUID id)  {
        return ResponseEntity.ok().body(cursService.getCursById(id));
    }
}
