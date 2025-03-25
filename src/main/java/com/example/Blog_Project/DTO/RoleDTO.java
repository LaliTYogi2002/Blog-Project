package com.example.Blog_Project.DTO;

import com.example.Blog_Project.Enum.RoleStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {

    private Long id; // ✅ Only included in response DTOs (not required in request)

    @NotBlank(message = "Role name cannot be empty")
    private String name;

    @NotNull(message = "Role status cannot be null")
    private RoleStatusEnum status;
}
