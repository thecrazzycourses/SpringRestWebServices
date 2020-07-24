package com.carzzy.rahul.repository;

import com.carzzy.rahul.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
