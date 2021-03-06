package IuromInvoices.dao.daoClient;

import IuromInvoices.exception.ClientNotFoundException;
import IuromInvoices.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresClient")
public class ClientDataAccessService implements ClientDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Client insertClient(UUID id, Client client) {
        String sql = "INSERT INTO clients (" +
                " id, " +
                " nume, " +
                " cui, " +
                " adresa, " +
                " nrcont)" +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id,
                client.getNume(),
                client.getCui(),
                client.getAdresa(),
                client.getNrCont()
        );
        client.setId(id);
        return client;
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
        final String sql = "SELECT id, nume, cui, adresa, nrcont FROM clients where id = ?";
        RowMapper<Client> mapper = (resultSet, i) -> {
            UUID clientId = UUID.fromString(resultSet.getString("id"));
            String nume = resultSet.getString("nume");
            String cui = resultSet.getString("cui");
            String adresa = resultSet.getString("adresa");
            String nrCont = resultSet.getString("nrcont");
            return new Client(clientId, nume, cui, adresa, nrCont);
        };
        List<Client> client = jdbcTemplate.query(
                sql,
                mapper,
                id);
        if (!client.isEmpty()) {
            return Optional.of(client.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteClientById(UUID id) {
        String sql = "DELETE FROM clients " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    @Override
    public int updateClientById(UUID id, Client client) {
        String sql = "UPDATE clients " +
                "SET nume = ?, " +
                " cui = ?, " +
                " adresa = ?, " +
                " nrcont = ? " +
                "WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                client.getNume(),
                client.getCui(),
                client.getAdresa(),
                client.getNrCont(),
                id
        );
    }
}
