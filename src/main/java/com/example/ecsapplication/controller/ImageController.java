package com.example.ecsapplication.controller;

import com.example.ecsapplication.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("images", imageService.getAllImages());
        return "home";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file,
                              @RequestParam("title") String title,
                              @RequestParam("description") String description) {
        imageService.addImage(file, title, description);
        return "redirect:/images";
    }

    @PostMapping("/{id}")
    public String deleteImageById(@PathVariable Long id) {
        imageService.deleteImageById(id);
        return "redirect:/images";
    }
}

