package com.example.ecsapplication.service;

import com.example.ecsapplication.dto.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    ImageResponse addImage(MultipartFile file, String title, String description);
    List<ImageResponse> getAllImages();
    ImageResponse getImageById(Long id);
    String deleteImageById(Long id);
}
