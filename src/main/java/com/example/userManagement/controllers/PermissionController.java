package com.example.userManagement.controllers;


import com.example.userManagement.models.Action;
import com.example.userManagement.models.Permission;
import com.example.userManagement.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.createPermission(permission));
    }

    @GetMapping("/{permissionId}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable String permissionId) {
        Optional<Permission> permission = permissionService.getPermissionById(permissionId);
        return permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping("/{permissionId}/actions")
//    public ResponseEntity<List<Action>> getActionsForPermission(@PathVariable String permissionId) {
//        return ResponseEntity.ok(permissionService.getActionsForPermission(permissionId));
//    }

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

//    @PutMapping("/{permissionId}")
//    public ResponseEntity<Permission> updatePermission(@PathVariable String permissionId, @RequestBody Permission permission) {
//        try {
//            return ResponseEntity.ok(permissionService.updatePermission(permissionId, permission));
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{permissionId}")
    public ResponseEntity<Void> deletePermission(@PathVariable String permissionId) {
        permissionService.deletePermission(permissionId);
        return ResponseEntity.noContent().build();
    }
}
