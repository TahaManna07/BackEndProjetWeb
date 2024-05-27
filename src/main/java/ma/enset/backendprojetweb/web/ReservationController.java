package ma.enset.backendprojetweb.web;

import lombok.AllArgsConstructor;
import ma.enset.backendprojetweb.entities.Reservation;
import ma.enset.backendprojetweb.entities.Session;
import ma.enset.backendprojetweb.entities.User;
import ma.enset.backendprojetweb.repositories.ReservationRepository;
import ma.enset.backendprojetweb.repositories.SessionRepository;
import ma.enset.backendprojetweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@AllArgsConstructor
public class ReservationController {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @PostMapping("/reservations")
    @PreAuthorize("hasAuthority('SCOPE_USER')")

    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @DeleteMapping("/reservations/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    public void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }

    @GetMapping("/users/{userId}/reservations")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    public List<Reservation> getUserReservations(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return reservationRepository.findByUser(user);
    }

    @GetMapping("/sessions/{sessionId}/reservations")
    @PreAuthorize("hasAuthority('SCOPE_USER')")

    public List<Reservation> getSessionReservations(@PathVariable Long sessionId) {
        Session session = sessionRepository.findById(sessionId).orElse(null);
        return reservationRepository.findBySession(session);
    }
    @GetMapping("/reservations")
    @PreAuthorize("hasAuthority('SCOPE_USER')")

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

}
