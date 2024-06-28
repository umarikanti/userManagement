package com.example.userManagement.services;

import com.example.userManagement.exceptions.ResourceNotFoundException;
import com.example.userManagement.models.Action;
import com.example.userManagement.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public Action createAction(Action action) {
        return actionRepository.save(action);
    }

    public Action getActionById(String actionId) {
        return actionRepository.findByActionId(actionId)
                .orElseThrow(() -> new ResourceNotFoundException("Action not found with actionId " + actionId));
    }

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

//    public Action updateAction(String actionId, Action actionDetails) {
//        Action action = actionRepository.findByActionId(actionId)
//                .orElseThrow(() -> new ResourceNotFoundException("Action not found with actionId " + actionId));
//
//        action.setName(actionDetails.getName());
//        return actionRepository.save(action);
//    }

    public void deleteAction(String actionId) {
        Action action = actionRepository.findByActionId(actionId)
                .orElseThrow(() -> new ResourceNotFoundException("Action not found with actionId " + actionId));
        actionRepository.delete(action);
    }
}
