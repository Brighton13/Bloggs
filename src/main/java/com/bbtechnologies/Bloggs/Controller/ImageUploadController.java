package com.bbtechnologies.Bloggs.Controller;

import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
    public class ImageUploadController {


        private String uploadPath;

        @PostMapping("/upload")
        public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {
            try {
                // Save the file to the specified path
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Files.copy(file.getInputStream(), Paths.get(uploadPath, fileName), StandardCopyOption.REPLACE_EXISTING);

                model.addAttribute("message", "Image uploaded successfully.");
                return "redirect:/";
            } catch (IOException e) {
                model.addAttribute("error", "Error uploading image.");
                return "redirect:/";
            }
        }
    }


