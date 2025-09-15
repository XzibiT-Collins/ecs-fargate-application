package com.example.ecsapplication.service.serviveImpl;

import com.example.ecsapplication.dto.ImageRequest;
import com.example.ecsapplication.dto.ImageResponse;
import com.example.ecsapplication.mapper.ImageMapper;
import com.example.ecsapplication.model.Image;
import com.example.ecsapplication.repository.ImageRepository;
import com.example.ecsapplication.service.ImageService;
import com.example.ecsapplication.utils.S3Bucket;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final S3Bucket s3Bucket;


    public ImageServiceImpl(ImageRepository imageRepository, S3Bucket s3Bucket) {
        this.imageRepository = imageRepository;
        this.s3Bucket = s3Bucket;
    }

    @Override
    public ImageResponse addImage(MultipartFile file, String title, String description) {
        ImageRequest request = ImageRequest.builder().file(file).title(title).description(description).build();

        if(request.getFile() == null){
            throw new IllegalArgumentException("Image file is required");
        }

        String imageUrl = s3Bucket.uploadImage(request.getFile());

        Image image = ImageMapper.toImage(request);

        image.setUrl(imageUrl);
        imageRepository.save(image);
        return ImageMapper.toImageResponse(image);
    }

    @Override
    public List<ImageResponse> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return images.stream().map(ImageMapper::toImageResponse).toList();
    }

    @Override
    public ImageResponse getImageById(Long id) {
        if(imageRepository.existsById(id)){
            imageRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public String deleteImageById(Long id) {
        if(imageRepository.existsById(id)){
            imageRepository.deleteById(id);
            return "Image deleted successfully";
        }
        return "Image not found";
    }
}
