package IuromInvoices.dao.daoAbonament;

import IuromInvoices.models.Abonament;
import IuromInvoices.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresAbonament")
public class AbonamentDataAccessService implements AbonamentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AbonamentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Abonament insertAbonament(Long id, Abonament abonament) {
        String sql = "INSERT INTO abonamente (" +
                " id, " +
                " nume, " +
                " pret, " +
                " valabilitate, " +
                " limitaFacturi)" +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id,
                abonament.getNume(),
                abonament.getPret(),
                abonament.getValabilitate(),
                abonament.getLimitaFacturi()
        );
        abonament.setId(id);
        return abonament;
    }

    @Override
    public Optional<Abonament> selectAbonamentById(Long id) {
        final String sql = "SELECT id, nume, pret, valabilitate, limitaFacturi FROM abonamente where id = ?";
        RowMapper<Abonament> mapper = (resultSet, i) -> {
            Long abonamentId = resultSet.getLong("id");
            String nume = resultSet.getString("nume");
            float pret = resultSet.getFloat("pret");
            Date valabilitate = resultSet.getDate("valabilitate");
            int limitaFacturi = resultSet.getInt("limitaFacturi");
            return new Abonament(abonamentId, nume, pret, valabilitate, limitaFacturi);
        };
        List<Abonament> abonament = jdbcTemplate.query(
                sql,
                mapper,
                id);
        if (!abonament.isEmpty()) {
            return Optional.of(abonament.get(0));
        } else {
            return Optional.empty();
        }
    }
}
