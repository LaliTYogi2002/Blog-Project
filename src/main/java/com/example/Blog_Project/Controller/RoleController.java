package com.example.Blog_Project.Controller;

import com.example.Blog_Project.DTO.RoleDTO;
import com.example.Blog_Project.Model.Role;
import com.example.Blog_Project.Service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // ✅ Create a new role with validation
    @PostMapping
    public ResponseEntity<?> createRole(@Valid @RequestBody RoleDTO roleDTO) {
        Role createdRole = roleService.createRole(roleDTO);
        return ResponseEntity.ok(createdRole);
    }

    // ✅ Get all roles
//    @GetMapping
//    public ResponseEntity<List<RoleDTO>> getAllRoles() {
//        List<RoleDTO> roles = roleService.getAllRoles();
//        return ResponseEntity.ok(roles);
//    }
//
//    // ✅ Get role by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
//        RoleDTO roleDTO = roleService.getRoleById(id);
//        return ResponseEntity.ok(roleDTO);
//    }
//
//    // ✅ Update role
//    @PutMapping("/{id}")
//    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
//        RoleDTO updatedRole = roleService.updateRole(id, roleDTO);
//        return ResponseEntity.ok(updatedRole);
//    }
//
//    // ✅ Delete role
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
//        roleService.deleteRole(id);
//        return ResponseEntity.ok("Role deleted successfully");
//    }
}
