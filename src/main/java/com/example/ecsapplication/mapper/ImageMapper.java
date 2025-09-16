package com.example.ecsapplication.mapper;

import com.example.ecsapplication.dto.ImageRequest;
import com.example.ecsapplication.dto.ImageResponse;
import com.example.ecsapplication.model.Image;

public class ImageMapper {
    private ImageMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Image toImage(ImageRequest request){
        return Image.builder().title(request.getTitle()).description(request.getDescription()).build();
    }

    public static ImageResponse toImageResponse(Image image){
        return ImageResponse
                .builder()
                .id(image.getId())
                .title(image.getTitle())
                .url(image.getUrl())
                .description(image.getDescription())
                .uploadDate(image.getUploadDate())
                .build();
    }
}
