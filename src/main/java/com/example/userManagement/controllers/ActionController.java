package com.example.userManagement.controllers;

import com.example.userManagement.models.Action;
import com.example.userManagement.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @PostMapping
    public ResponseEntity<Action> createAction(@RequestBody Action action) {
        Action createdAction = actionService.createAction(action);
        return ResponseEntity.ok(createdAction);
    }

    @GetMapping("/{actionId}")
    public ResponseEntity<Action> getActionById(@PathVariable String actionId) {
        Action action = actionService.getActionById(actionId);
        return ResponseEntity.ok(action);
    }

    @GetMapping
    public ResponseEntity<List<Action>> getAllActions() {
        List<Action> actions = actionService.getAllActions();
        return ResponseEntity.ok(actions);
    }

  //  @PutMapping("/{actionId}")
//    public ResponseEntity<Action> updateAction(@PathVariable String actionId, @RequestBody Action actionDetails) {
//        Action updatedAction = actionService.updateAction(actionId, actionDetails);
//        return ResponseEntity.ok(updatedAction);
//    }

    @DeleteMapping("/{actionId}")
    public ResponseEntity<Void> deleteAction(@PathVariable String actionId) {
        actionService.deleteAction(actionId);
        return ResponseEntity.noContent().build();
    }
}
