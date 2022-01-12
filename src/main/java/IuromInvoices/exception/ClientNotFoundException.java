package IuromInvoices.exception;

public class ClientNotFoundException extends NotFoundException {

    public ClientNotFoundException() {
        super("Clientul nu a fost gasit!");
    }
}
