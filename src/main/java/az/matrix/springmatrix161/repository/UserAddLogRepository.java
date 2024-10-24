package az.matrix.springmatrix161.repository;

import az.matrix.springmatrix161.entity.UserAddLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAddLogRepository extends JpaRepository<UserAddLog, Long> {

    Optional<UserAddLog> findByUser_Id(Long id);
}
