package com.senai.task.repositories;

import com.senai.task.models.TaskModel;
import com.senai.task.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    Optional<List<TaskModel>> findByEmail(String emai);
}
