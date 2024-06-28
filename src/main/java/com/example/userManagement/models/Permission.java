package com.example.userManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String permissionId;

    @Column(nullable = false)
    private String name;

     @Column(name = "action_module_id", nullable = false)
     private String moduleId;

  //  @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, orphanRemoval = true)
  //z  private List<Action> actions = new ArrayList<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getPermissionId() {
//        return permissionId;
//    }
//
//    public void setPermissionId(String permissionId) {
//        this.permissionId = permissionId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
////    public String getModule() {
//        return module;
//    }
//
//    public void setModule(String module) {
//        this.module = module;
//    }
//
//    public List<Action> getActions() {
//        return actions;
//    }
//
//    public void setActions(List<Action> actions) {
//        this.actions = actions;
//    }
}
