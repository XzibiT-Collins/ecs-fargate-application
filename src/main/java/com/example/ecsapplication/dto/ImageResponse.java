package com.example.ecsapplication.dto;

import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse{
    private Long id;
    private String url;
    private String title;
    private String description;
    private LocalDateTime uploadDate;
}
