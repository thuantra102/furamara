package com.example.furama.model.user;

import javax.persistence.*;

@Entity
@Table(name = "user_role",uniqueConstraints = {
        @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "user_id", "role_id" }) })

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private AppRole appRole;

    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public AppRole getRole() {
        return appRole;
    }

    public void setRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
