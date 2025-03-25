package com.example.Blog_Project.Service;

import com.example.Blog_Project.DTO.RoleDTO;
import com.example.Blog_Project.Model.Role;
import com.example.Blog_Project.Repository.RoleRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(RoleDTO roleDTO) {
        // 🔹 Check if role name already exists
        if (roleRepository.existsByName(roleDTO.getName())) {
            throw new ValidationException("Role with name '" + roleDTO.getName() + "' already exists");
        }

        Role role = new Role();
        role.setName(roleDTO.getName());
        role.setStatus(roleDTO.getStatus());

        return roleRepository.save(role);
    }

}
