// UserRepository.java
package com.habitiq.habitiqserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habitiq.habitiqserver.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Define custom query methods if needed
	Optional<User> findByEmail(String email);
}


