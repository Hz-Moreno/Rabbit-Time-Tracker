package com.rabbit.application.repositories;

import com.rabbit.application.models.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTaskRepository extends JpaRepository<DailyTask, Long> {
}
