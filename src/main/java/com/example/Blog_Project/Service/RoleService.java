package com.example.Blog_Project.Service;

import com.example.Blog_Project.DTO.RoleDTO;
import com.example.Blog_Project.Model.Role;
import com.example.Blog_Project.Repository.RoleRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> new RoleDTO(role.getId(), role.getName(), role.getStatus()))
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return new RoleDTO(role.getId(), role.getName(), role.getStatus());
    }

    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setName(roleDTO.getName());
        role.setStatus(roleDTO.getStatus());
        roleRepository.save(role);

        return new RoleDTO(role.getId(), role.getName(), role.getStatus());
    }

    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roleRepository.delete(role);
    }

}
