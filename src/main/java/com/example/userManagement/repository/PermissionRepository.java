
package com.example.userManagement.repository;

import com.example.userManagement.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByPermissionId(String permissionId);
    void deleteByPermissionId(String permissionId);
}
