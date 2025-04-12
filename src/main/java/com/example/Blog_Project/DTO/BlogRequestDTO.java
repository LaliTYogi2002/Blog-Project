package com.example.Blog_Project.DTO;

import com.example.Blog_Project.Enum.BlogStatusEnum;
import com.example.Blog_Project.Enum.BlogVisibilityEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BlogRequestDTO {

    @NotBlank(message = "Name may not be blank")
    private String title;
    private String description;
    private String tag;
    private BlogVisibilityEnum visibility;
    private BlogStatusEnum status;




}
