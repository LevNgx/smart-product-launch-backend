package com.launchpad.idea_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ideas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status; // e.g., Submitted, In Progress, Launch Ready

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Reference to the user who submitted the idea
}