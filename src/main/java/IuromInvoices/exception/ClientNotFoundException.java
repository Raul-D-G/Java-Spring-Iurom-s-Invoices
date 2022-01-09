package IuromInvoices.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("Clientul nu a fost gasit!");
    }
}
