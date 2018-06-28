package com.example.rngesus.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=3, max=30, message = "Usernames must be between 3 and 30 characters")
    @Column(unique = true)
    private String username;

    @NotNull
    @Email(message = "Please use a valid email address")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(min=6, message = "Password must be at least 6 characters long")
    @Column(nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name = "character_id")
    private List<PlayerCharacter> playerCharacters = new ArrayList<>();

    public User() { }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

}
