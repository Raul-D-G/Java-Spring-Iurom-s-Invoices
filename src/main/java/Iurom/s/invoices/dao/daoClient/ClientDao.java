package Iurom.s.invoices.dao.daoClient;

import Iurom.s.invoices.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientDao {

    int insertClient(UUID id, Client client);

    default int insertClient(Client client) {
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    List<Client> selectAllClients();

}