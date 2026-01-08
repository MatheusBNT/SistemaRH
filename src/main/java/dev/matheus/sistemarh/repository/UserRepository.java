package dev.matheus.sistemarh.repository;

import dev.matheus.sistemarh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID> {
}
