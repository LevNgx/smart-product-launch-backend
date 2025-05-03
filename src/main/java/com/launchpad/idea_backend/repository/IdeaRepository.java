package com.launchpad.idea_backend.repository;

import com.launchpad.idea_backend.model.Idea;
import com.launchpad.idea_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdeaRepository extends JpaRepository<Idea, Long> {

    List<Idea> findByUser(User user);
    List<Idea> findByStatus(String status);
}
