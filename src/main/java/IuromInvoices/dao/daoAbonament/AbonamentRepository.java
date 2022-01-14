package IuromInvoices.dao.daoAbonament;

import IuromInvoices.models.Abonament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonamentRepository extends JpaRepository<Abonament, Long> {
}
