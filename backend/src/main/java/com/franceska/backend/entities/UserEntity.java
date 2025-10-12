package com.franceska.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userId;
    @Column(unique = true)
    private String email;
    private String password;
    private String username;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @CreationTimestamp
    private Timestamp updatedAt;
}
