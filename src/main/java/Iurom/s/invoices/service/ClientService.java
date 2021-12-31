package Iurom.s.invoices.service;

import Iurom.s.invoices.dao.daoClient.ClientDao;
import Iurom.s.invoices.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDao clientDao;

    @Autowired
    public ClientService(@Qualifier("fakeDao") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public int addClient(Client client) {
        return clientDao.insertClient(client);
    }

    public List<Client> getAllClients() {
        return clientDao.selectAllClients();
    }
}
