package com.example.Blog_Project.Repository;

import com.example.Blog_Project.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
