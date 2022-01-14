package IuromInvoices.services;

import IuromInvoices.dao.daoFactura.FacturaRepository;
import IuromInvoices.exception.FacturaNotFoundException;
import IuromInvoices.models.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacturaService {
    private FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public Factura addFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura getFacturaById(Long id) {
        Optional<Factura> facturaOptional = facturaRepository.findById(id);
        if (facturaOptional.isPresent()) {
            return facturaOptional.get();
        }
        throw new FacturaNotFoundException();
    }
}
