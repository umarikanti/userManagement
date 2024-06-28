package com.example.userManagement.repository;

import com.example.userManagement.models.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    Optional<Action> findByActionId(String actionId);
}
