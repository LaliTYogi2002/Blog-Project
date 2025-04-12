package com.example.Blog_Project.DTO;

import com.example.Blog_Project.Enum.UserStatusEnum;
import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private UserStatusEnum status;
}
