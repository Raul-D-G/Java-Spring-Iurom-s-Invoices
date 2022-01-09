package IuromInvoices.dao.daoClient;

import IuromInvoices.models.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao {

    Client insertClient(UUID id, Client client);

    default Client insertClient(Client client) {
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    List<Client> selectAllClients();

    Optional<Client> selectClientById(UUID id);

    int deleteClientById(UUID id);

    int updateClientById(UUID id, Client client);
}