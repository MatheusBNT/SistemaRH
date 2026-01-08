package dev.matheus.sistemarh.controller;

import dev.matheus.sistemarh.model.User;
import dev.matheus.sistemarh.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>>  getAllUsers() {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.findAllUsers());
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user, @RequestParam UUID id) {
        userService.UpdateUser(user, id);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> DeleteUser(@RequestParam UUID id) {
        userService.deleteUser(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted successfully");
    }
}
