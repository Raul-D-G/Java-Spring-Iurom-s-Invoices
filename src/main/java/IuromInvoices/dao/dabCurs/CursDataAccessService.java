package IuromInvoices.dao.dabCurs;

import IuromInvoices.models.Curs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresCurs")
public class CursDataAccessService implements CursDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CursDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Curs insertCurs(UUID id, Curs curs) {
        String sql = "INSERT INTO curs(" +
                " id, " +
                " nume,  " +
                " paritate)" +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id,
                curs.getNume(),
                curs.getParitate()
        );
        curs.setId(id);
        return curs;
    }

    @Override
    public Optional<Curs> selectCursById(UUID id) {
        final String sql = "SELECT id, nume, paritate FROM curs where id = ?";
        RowMapper<Curs> mapper = (resultSet, i) -> {
            UUID cursId = UUID.fromString(resultSet.getString("id"));
            String nume = resultSet.getString("nume");
            float paritate = resultSet.getFloat("paritate");
            return new Curs(cursId, nume, paritate);
        };
        List<Curs> curs = jdbcTemplate.query(
                sql,
                mapper,
                id);
        if (!curs.isEmpty()) {
            return Optional.of(curs.get(0));
        } else {
            return Optional.empty();
        }
    }
}
