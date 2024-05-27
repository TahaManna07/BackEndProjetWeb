package ma.enset.backendprojetweb.web;

import lombok.AllArgsConstructor;
import ma.enset.backendprojetweb.entities.Session;
import ma.enset.backendprojetweb.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@AllArgsConstructor
public class SessionController {

    private SessionRepository sessionRepository;

    @PostMapping("/sessions")
    @PreAuthorize("hasAuthority('SCOPE_USER')")

    public Session createSession(@RequestBody Session session) {
        return sessionRepository.save(session);
    }

    @GetMapping("/sessions/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")

    public Session getSession(@PathVariable Long id) {
        return sessionRepository.findById(id).orElseThrow(null);
    }


    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @GetMapping("/sessions")

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}

