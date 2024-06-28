package com.example.userManagement.models;

import jakarta.persistence.*;

@Entity
@Table(name = "actions")
public class Action {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
   private String name;

//    @Column(name = "action_id", nullable = false, unique = true)
    private String actionId;

    // If you need to add moduleId in the future, uncomment the following lines
//     @Column(name = "action_module_id", nullable = false)
//     private String moduleId;

    // If you need to establish a relationship with the Permission entity, uncomment these lines
    // @ManyToOne
    // @JoinColumn(name = "permission_id", nullable = false)
    // private Permission permission;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
////
//    public String getActionId() {
//        return actionId;
//    }
//
//    public void setActionId(String actionId) {
//        this.actionId = actionId;
//    }

    // Uncomment these getters and setters if you add moduleId or permission
    // public String getModuleId() {
    //     return moduleId;
    // }

    // public void setModuleId(String moduleId) {
    //     this.moduleId = moduleId;
    // }

    // public Permission getPermission() {
    //     return permission;
    // }

    // public void setPermission(Permission permission) {
    //     this.permission = permission;
    // }
}
