package ma.enset.backendprojetweb.repositories;
import ma.enset.backendprojetweb.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
