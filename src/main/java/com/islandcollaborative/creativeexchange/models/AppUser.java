package com.islandcollaborative.creativeexchange.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    String username;
    String password;
    String displayName;
    Boolean isCreator;
    //TODO Picture

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> sentMessages;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> receivedMessages;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> posts;

    //TODO follow another user

    @CreationTimestamp
    LocalDateTime createdAt;
}
