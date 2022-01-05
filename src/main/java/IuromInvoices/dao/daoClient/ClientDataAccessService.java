package IuromInvoices.dao.daoClient;

import IuromInvoices.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ClientDataAccessService implements ClientDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertClient(UUID id, Client client) {
        return 0;
    }

    @Override
    public List<Client> selectAllClients() {
        final String sql = "SELECT id, nume, cui, adresa, nrcont FROM clients";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String nume = resultSet.getString("nume");
            String cui = resultSet.getString("cui");
            String adresa = resultSet.getString("adresa");
            String nrCont = resultSet.getString("nrcont");
            return new Client(id, nume, cui, adresa, nrCont);
        });
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteClientById(UUID id) {
        return 0;
    }

    @Override
    public int updateClientById(UUID id, Client client) {
        return 0;
    }
}
