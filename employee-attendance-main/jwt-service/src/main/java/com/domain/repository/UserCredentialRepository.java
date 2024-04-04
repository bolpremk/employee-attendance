package com.domain.repository;

import com.domain.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for accessing UserCredential entities in the database.
 */
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for.
     * @return An optional containing the user if found, or empty if not found.
     */
    Optional<UserCredential> findByName(String username);
}
