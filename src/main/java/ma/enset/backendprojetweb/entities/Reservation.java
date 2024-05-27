package ma.enset.backendprojetweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate reservationDate;

    @ManyToOne(fetch  = FetchType.EAGER)
    @JoinColumn(name = "user_id")

    private User user;

    @ManyToOne(fetch  = FetchType.EAGER)
    @JoinColumn(name = "session_id")

    private Session session;

    // getters and setters
}
