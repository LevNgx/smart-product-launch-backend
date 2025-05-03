package com.launchpad.idea_backend.controller;

import com.launchpad.idea_backend.dto.IdeaRequest;
import com.launchpad.idea_backend.model.Idea;
import com.launchpad.idea_backend.model.User;
import com.launchpad.idea_backend.service.IdeaService;
import com.launchpad.idea_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ideas")
public class IdeaController {
    @Autowired
    private IdeaService ideaService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> submitIdea(@Valid @RequestBody IdeaRequest ideaRequest) {
        Optional<User> user = userService.findById(ideaRequest.getUserId());
        if(user.isEmpty()){
            return ResponseEntity.status(404).body("User not found");
        }
        Idea idea = new Idea();
        idea.setDescription(ideaRequest.getDescription());
        idea.setTitle(ideaRequest.getTitle());
        idea.setUser(user.get());
        idea.setStatus(ideaRequest.getStatus());
        return ResponseEntity.ok(ideaService.submitIdea(idea));
    }

    @GetMapping
    public ResponseEntity<List<Idea>> getAllIdeas() {
        return ResponseEntity.ok(ideaService.getAllIdeas());
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getIdeasByUser(@PathVariable Long userId){
        Optional<User> userOpt = userService.findById(userId);
        return userOpt
                .map(user -> ResponseEntity.ok(ideaService.getIdeasByUser(user)))
                .orElseGet(() -> ResponseEntity.status(404).body(Collections.emptyList()));
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Idea>> getIdeasByStatus(@PathVariable String status) {
        return ResponseEntity.ok(ideaService.getIdeasByStatus(status));
    }

}
