package Iurom.s.invoices.dao.daoClient;

import Iurom.s.invoices.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
}
