package com.example.Blog_Project.Repository;

import com.example.Blog_Project.Model.Role;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(@NotBlank(message = "Role name cannot be empty") String name);
    Optional<Role> findByName(String name);

}
