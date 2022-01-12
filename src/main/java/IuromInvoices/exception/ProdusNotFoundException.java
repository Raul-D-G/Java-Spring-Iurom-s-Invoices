package IuromInvoices.exception;

public class ProdusNotFoundException extends NotFoundException {

    public ProdusNotFoundException() {
        super("Produsul nu a fost gasit!");
    }
}
