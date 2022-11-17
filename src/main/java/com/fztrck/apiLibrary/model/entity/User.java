package com.fztrck.apiLibrary.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(unique = true, nullable = false)
        private String email;

        @Column(nullable = false)
        private String password;

        private LocalDateTime createdAt = LocalDateTime.now();
        private LocalDateTime updateAt = LocalDateTime.now();
        private boolean isDeleted = false;

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }

}
