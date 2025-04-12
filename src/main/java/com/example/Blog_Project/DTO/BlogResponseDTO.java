package com.example.Blog_Project.DTO;

import com.example.Blog_Project.Enum.BlogStatusEnum;
import com.example.Blog_Project.Enum.BlogVisibilityEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class BlogResponseDTO {

    @NotBlank(message = "Name may not be blank")
    private String title;
    private String description;

    @NotEmpty(message = "visibility may not be empty")
    private BlogVisibilityEnum visibility;

    @NotBlank(message = "Status may not be empty")
    private BlogStatusEnum status;

    private String tag;

    @NotNull(message = "Created at may not be null")
    private LocalDateTime createdAt;

    @NotNull(message = "Updated at may not be null")
    private LocalDateTime updatedAt;
}
