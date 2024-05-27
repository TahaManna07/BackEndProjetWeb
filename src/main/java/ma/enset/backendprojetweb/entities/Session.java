package ma.enset.backendprojetweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sessionName;

    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
    @JsonIgnore

    private Set<Reservation> reservations;

}
