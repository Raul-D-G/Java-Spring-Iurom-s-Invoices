package IuromInvoices.dao.daoProdus;

import IuromInvoices.models.Client;
import IuromInvoices.models.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresProdus")
public class ProdusDatAccessService implements ProdusDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProdusDatAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertProdus(UUID id, Produs produs) {
        String sql = "INSERT INTO produse (" +
                " id, " +
                " nume, " +
                " pret, " +
                " tva, " +
                " cantitate, " +
                " unitatemasura, " +
                " descriere)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                id,
                produs.getNume(),
                produs.getPret(),
                produs.getTva(),
                produs.getCantitate(),
                produs.getUnitateMasura(),
                produs.getDescriere()
        );
    }

    @Override
    public List<Produs> selectAllProduse() {
        final String sql = "SELECT id, nume, pret, tva, cantitate, unitatemasura, descriere FROM produse";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String nume = resultSet.getString("nume");
            float pret = resultSet.getFloat("pret");
            int tva = resultSet.getInt("tva");
            int cantitate = resultSet.getInt("cantitate");
            String unitatemasura = resultSet.getString("unitatemasura");
            String descriere = resultSet.getString("descriere");
            return new Produs(id, nume, pret, tva, cantitate, unitatemasura, descriere);
        });
    }

    @Override
    public Optional<Produs> selectProdusById(UUID id) {
        final String sql = "SELECT id, nume, pret, tva, cantitate, unitatemasura, descriere FROM produse where id = ?";
        Produs produs = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID produsId = UUID.fromString(resultSet.getString("id"));
                    String nume = resultSet.getString("nume");
                    float pret = resultSet.getFloat("pret");
                    int tva = resultSet.getInt("tva");
                    int cantitate = resultSet.getInt("cantitate");
                    String unitatemasura = resultSet.getString("unitatemasura");
                    String descriere = resultSet.getString("descriere");
                    return new Produs(produsId, nume, pret, tva, cantitate, unitatemasura, descriere);
                });
        return Optional.ofNullable(produs);
    }

    @Override
    public int deleteProdusById(UUID id) {
        String sql = "DELETE FROM produse " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateProdusById(UUID id, Produs produs) {
        String sql = "UPDATE produse " +
                "SET nume = ?, " +
                " pret = ?, " +
                " tva = ?, " +
                " cantitate = ?, " +
                " unitatemasura = ?, " +
                " descriere = ? " +
                "WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                produs.getNume(),
                produs.getPret(),
                produs.getTva(),
                produs.getCantitate(),
                produs.getUnitateMasura(),
                produs.getDescriere(),
                id
        );
    }
}
