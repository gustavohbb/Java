package com.senai.task.repositories;

import com.senai.task.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String emai);
}
