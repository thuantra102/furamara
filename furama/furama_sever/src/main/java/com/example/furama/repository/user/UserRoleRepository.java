package com.example.furama.repository.user;

import com.example.furama.model.user.AppUser;
import com.example.furama.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository  extends JpaRepository<UserRole,Integer> {
    List<UserRole> findByUser(AppUser appUser);
    //Nếu sử dụng  manytomany thì cần phải thay dổi repository này thành ROLE và
    //sử dụng @Query để có thể lấu list<Role> dựa vào AppUser (người đang đăng nhập)
}
