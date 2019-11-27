package com.site.carsite.repos;

import com.site.carsite.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String name);
}