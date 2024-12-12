package me.yangsongi.reviewmate.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", unique = true)
    private String email; // 유저 이메일

    @Column(name = "username", unique = true)
    private String username; // 유저 이름

    @Column(name = "password")
    private String password; // 유저 비밀번호

    @Builder
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
