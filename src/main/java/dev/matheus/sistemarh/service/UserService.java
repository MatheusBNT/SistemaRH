package dev.matheus.sistemarh.service;

import dev.matheus.sistemarh.model.User;
import dev.matheus.sistemarh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void createUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(()
                -> new RuntimeException("User with id not found"));
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void UpdateUser(User user, UUID id) {
        User oldUser = findUserById(id);
        User updatedUser = User.builder()
                .firstName(user.getFirstName() != null
                        ? user.getFirstName() : oldUser.getFirstName())
                .lastName(user.getLastName() != null
                        ? user.getLastName() : oldUser.getLastName())
                .email(user.getEmail() != null
                        ? user.getEmail() : oldUser.getEmail())
                .id(oldUser.getId())
                .build();

        userRepository.save(updatedUser);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
