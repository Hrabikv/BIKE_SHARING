package com.example.bike_sharing.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

/**
 * Represents a single user of the service.
 */
@Entity
public class User {
    /**
     * Unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)*/
    private Long id;
    /**
     * Full name of the user.
     */
    private String name;
    /**
     * Email address of the user, used for log in.
     */
    private String emailAddress;
    /**
     * Role of the user.
     */
    private Role role;

    public User(String name, String emailAddress, Role role) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.role = role;
    }

    public User() {
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Role getRole() {
        return role;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(emailAddress, user.emailAddress) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, emailAddress, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", role=" + role +
                '}';
    }

    public enum Role {
        /**
         * Regular user
         */
        REGULAR,
        /**
         * Serviceman, can do everything that regular users but also maintains bikes
         */
        SERVICEMAN,
    }
}