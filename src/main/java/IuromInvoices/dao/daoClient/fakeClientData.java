package IuromInvoices.dao.daoClient;

import IuromInvoices.models.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class fakeClientData implements ClientDao {

    private static List<Client> DB = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {
        DB.add(new Client(id, client.getNume(), client.getCui(), client.getAdresa(), client.getNrCont()));
        return 1;
    }

    @Override
    public List<Client> selectAllClients() {
        return DB;
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {
        return DB.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteClientById(UUID id) {
        Optional<Client>  clientOptional = selectClientById(id);
        if (clientOptional.isEmpty()) {
            return 0;
        }
        DB.remove(clientOptional.get());
        return 1;
    }

    @Override
    public int updateClientById(UUID id, Client client) {
        return selectClientById(id)
                .map(client1 -> {
                    int indexOfClientToUpdate = DB.indexOf(client1);
                    if (indexOfClientToUpdate >= 0) {
                        DB.set(indexOfClientToUpdate,
                                new Client(id, client.getNume(), client.getCui(), client.getAdresa(), client.getNrCont()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
