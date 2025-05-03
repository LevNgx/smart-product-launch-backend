package com.launchpad.idea_backend.service;

import com.launchpad.idea_backend.model.Idea;
import com.launchpad.idea_backend.model.User;
import com.launchpad.idea_backend.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    public Idea submitIdea(Idea idea){
        return ideaRepository.save(idea);
    }

    public List<Idea> getAllIdeas(){
        return ideaRepository.findAll();
    }

    public List<Idea> getIdeasByUser(User user){
        return ideaRepository.findByUser(user);
    }

    public List<Idea> getIdeasByStatus(String status){
        return ideaRepository.findByStatus(status);
    }

    public Optional<Idea> findById(Long id){
        return ideaRepository.findById(id);
    }
}
