package com.example.leeterboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int problemsSolved;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    // Getters, Setters, Constructors, etc.
}
