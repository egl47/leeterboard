package com.example.leeterboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import java.util.HashSet;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int problemsSolved;
    private int easyProblemsSolved;
    private int mediumProblemsSolved;
    private int hardProblemsSolved;

    @ManyToMany(mappedBy = "users")
    private Set<Room> rooms = new HashSet<>();

    public User() {}
    
    public User(String username) {
        this.username = username;
        this.problemsSolved = 0;
        this.easyProblemsSolved = 0;
        this.mediumProblemsSolved = 0;
        this.hardProblemsSolved = 0;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProblemsSolved() {
        return problemsSolved;
    }

    public void setProblemsSolved(int problemsSolved) {
        this.problemsSolved = problemsSolved;
    }

    public int getEasyProblemsSolved() {
        return easyProblemsSolved;
    }

    public void setEasyProblemsSolved(int easyProblemsSolved) {
        this.easyProblemsSolved = easyProblemsSolved;
    }

    public int getMediumProblemsSolved() {
        return mediumProblemsSolved;
    }

    public void setMediumProblemsSolved(int mediumProblemsSolved) {
        this.mediumProblemsSolved = mediumProblemsSolved;
    }

    public int getHardProblemsSolved() {
        return hardProblemsSolved;
    }

    public void setHardProblemsSolved(int hardProblemsSolved) {
        this.hardProblemsSolved = hardProblemsSolved;
    }
}
