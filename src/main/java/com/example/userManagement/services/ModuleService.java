package com.example.userManagement.services;

import com.example.userManagement.dto.ModuleDTO;
import com.example.userManagement.exceptions.ResourceNotFoundException;
import com.example.userManagement.models.Module;
import com.example.userManagement.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public Module createModule(ModuleDTO moduleDTO) {
        Module module = new Module();
        module.setName(moduleDTO.getName());
        module.setPath(moduleDTO.getPath());
        module.setDisplayOrder(moduleDTO.getDisplayOrder());
        module.setCreatedBy(moduleDTO.getCreatedBy());
        module.setCreatedDate(new Date());

        if (moduleDTO.getParentModuleId() != null) {
            Module parentModule = moduleRepository.findById(moduleDTO.getParentModuleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent Module not found with id " + moduleDTO.getParentModuleId()));
            module.setParentModule(parentModule);
        }

        return moduleRepository.save(module);
    }

    public Module updateModule(Long id, ModuleDTO moduleDTO) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id " + id));

        module.setName(moduleDTO.getName());
        module.setPath(moduleDTO.getPath());
        module.setDisplayOrder(moduleDTO.getDisplayOrder());
        module.setModifiedBy(moduleDTO.getModifiedBy());
        module.setModifiedDate(new Date());

        if (moduleDTO.getParentModuleId() != null) {
            Module parentModule = moduleRepository.findById(moduleDTO.getParentModuleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent Module not found with id " + moduleDTO.getParentModuleId()));
            module.setParentModule(parentModule);
        } else {
            module.setParentModule(null);
        }

        return moduleRepository.save(module);
    }

    public Module getModuleById(Long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id " + id));
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public void deleteModule(Long id) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id " + id));
        moduleRepository.delete(module);
    }
}
