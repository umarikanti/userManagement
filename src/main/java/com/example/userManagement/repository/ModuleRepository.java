package com.example.userManagement.repository;




import com.example.userManagement.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ModuleRepository extends JpaRepository<Module, Long> {
    }


