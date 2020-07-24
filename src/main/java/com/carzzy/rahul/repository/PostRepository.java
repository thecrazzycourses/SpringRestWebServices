package com.carzzy.rahul.repository;

import com.carzzy.rahul.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
