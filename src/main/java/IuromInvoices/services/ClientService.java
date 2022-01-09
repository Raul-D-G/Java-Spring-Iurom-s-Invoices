package IuromInvoices.services;

import IuromInvoices.dao.daoClient.ClientDao;
import IuromInvoices.exception.ClientNotFoundException;
import IuromInvoices.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientDao clientDao;

    @Autowired
    public ClientService(@Qualifier("postgresClient") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Client addClient(Client client) {
        return clientDao.insertClient(client);
    }

    public List<Client> getAllClients() {
        return clientDao.selectAllClients();
    }

    public Client getClientById(UUID id) {
        Optional<Client> clientOptional = clientDao.selectClientById(id);
        if (clientOptional.isPresent()) {
            return clientOptional.get();
        } else {
            throw new ClientNotFoundException();
        }
    }

    public int deleteClient(UUID id) {
        return clientDao.deleteClientById(id);
    }

    public int  updateClient(UUID id, Client client) {
        return clientDao.updateClientById(id, client);
    }
}
