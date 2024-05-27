package ma.enset.backendprojetweb.repositories;

import ma.enset.backendprojetweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
