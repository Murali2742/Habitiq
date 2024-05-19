package com.habitiq.habitiqserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habitiq.habitiqserver.model.Habit;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    // Define custom query methods if needed
	List<Habit> findByEmail(String email);
}
