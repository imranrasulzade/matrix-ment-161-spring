package az.matrix.springmatrix161.repository;

import az.matrix.springmatrix161.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
