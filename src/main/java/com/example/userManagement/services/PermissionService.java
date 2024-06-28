package com.example.userManagement.services;



import com.example.userManagement.models.Action;
import com.example.userManagement.models.Permission;
import com.example.userManagement.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Optional<Permission> getPermissionById(String permissionId) {
        return permissionRepository.findByPermissionId(permissionId);
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

//    public Permission updatePermission(String permissionId, Permission permissionData) {
//        Optional<Permission> existingPermissionOptional = permissionRepository.findByPermissionId(permissionId);
//        if (!existingPermissionOptional.isPresent()) {
//            throw new RuntimeException("Permission not found");
//        }
//        Permission existingPermission = existingPermissionOptional.get();
//        existingPermission.setName(permissionData.getName());
//        existingPermission.setModule(permissionData.getModule());
//        existingPermission.setActions(permissionData.getActions());
//        return permissionRepository.save(existingPermission);
//    }

    public void deletePermission(String permissionId) {
        permissionRepository.deleteByPermissionId(permissionId);
    }

//    public List<Action> getActionsForPermission(String permissionId) {
//        Optional<Permission> permissionOptional = permissionRepository.findByPermissionId(permissionId);
//        if (permissionOptional.isPresent()) {
//            return permissionOptional.get().getActions();
//        }
//        throw new RuntimeException("Permission not found");
  //  }
}
