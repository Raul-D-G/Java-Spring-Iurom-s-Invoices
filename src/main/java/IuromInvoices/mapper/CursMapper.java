package IuromInvoices.mapper;

import IuromInvoices.dto.CursRequest;
import IuromInvoices.models.Curs;
import org.springframework.stereotype.Component;

@Component
public class CursMapper {

    public Curs cursRequestToCurs(CursRequest cursRequest) {
        return new Curs(cursRequest.getNume(), cursRequest.getParitate());
    }

}
