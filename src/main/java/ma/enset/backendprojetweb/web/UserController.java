package ma.enset.backendprojetweb.web;

import ma.enset.backendprojetweb.entities.User;
import ma.enset.backendprojetweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
