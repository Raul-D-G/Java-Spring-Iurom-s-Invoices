package IuromInvoices.exception;

public class CursNotFoundException extends NotFoundException {

    public CursNotFoundException() {
        super("Cursul de schimb nu a fost gasit");
    }
}
