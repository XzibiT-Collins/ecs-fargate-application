package com.example.ecsapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequest{
    @NotBlank(message = "Image name is required")
    private String title;

    @NotBlank(message = "Image description is required")
    @Size(max = 255, message = "Image description must be less than 255 characters")
    private String description;

    @NotNull(message = "Image file is required")
    private MultipartFile file;
}
