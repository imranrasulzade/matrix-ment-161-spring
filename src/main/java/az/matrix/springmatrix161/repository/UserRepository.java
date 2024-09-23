package az.matrix.springmatrix161.repository;

import az.matrix.springmatrix161.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
