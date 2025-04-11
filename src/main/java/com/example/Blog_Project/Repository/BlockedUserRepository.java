package com.example.Blog_Project.Repository;

import com.example.Blog_Project.Model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockedUserRepository extends JpaRepository<Block, Long> {
}
