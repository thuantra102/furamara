package com.example.furama.model.user;

import javax.persistence.*;

@Entity
@Table(name = "user",uniqueConstraints = {
@UniqueConstraint(name = "APP_USER_UK",columnNames = "name")
})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 36,nullable = false)
    private String name;
    @Column(length = 128,nullable = false)
    private String password;
    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
