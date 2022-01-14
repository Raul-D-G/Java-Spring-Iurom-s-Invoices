package IuromInvoices.exception;

public class FacturaNotFoundException extends NotFoundException {

    public FacturaNotFoundException() {
        super("Factura nu a fost gasita!");
    }
}
