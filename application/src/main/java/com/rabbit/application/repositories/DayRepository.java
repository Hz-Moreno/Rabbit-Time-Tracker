package com.rabbit.application.repositories;

import com.rabbit.application.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Long> {
}
