package ma.enset.backendprojetweb.repositories;

import ma.enset.backendprojetweb.entities.Reservation;
import ma.enset.backendprojetweb.entities.Session;
import ma.enset.backendprojetweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findBySession(Session session);
}