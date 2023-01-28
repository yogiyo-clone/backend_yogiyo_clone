package com.yogiyo.clone.domain.user.entity;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import com.yogiyo.clone.domain.user.dto.SignUpForm;
import com.yogiyo.clone.util.TimeStamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.yogiyo.clone.domain.user.entity.UserRole.USER;

@Getter
@Entity
@NoArgsConstructor
public class Users extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    private String username;

    private String email;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "users", orphanRemoval = true)
    private List<Store> store = new ArrayList<>();

    public Users(SignUpForm signUpForm) {
        this.username = signUpForm.getUsername();
        this.email = signUpForm.getEmail();
        this.password = signUpForm.getPassword();
        this.userRole = USER;
    }

    public Users(SignUpForm signUpForm, UserRole userRole) {
        this.username = signUpForm.getUsername();
        this.email = signUpForm.getEmail();
        this.password = signUpForm.getPassword();
        this.userRole = userRole;
    }

    @Builder
    public Users(String username, String email, String password, UserRole userRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}
