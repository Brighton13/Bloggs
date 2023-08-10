package com.bbtechnologies.Bloggs.Controller;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Repository.CourseRepository;
import com.bbtechnologies.Bloggs.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.util.UUID;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

//    String uploadPath="/static/Uploads";
//    @PostMapping("/Admin/Add/Course")
//    public String CreateNewCourse(@ModelAttribute Course course,MultipartFile file) throws IOException {
//        courseService.createCourse(file,course);
//        return "redirect:/";
//    }


    String FolderToStoreImages="C:\\Users\\F I L I M LIGHTS CW\\Desktop\\java projects\\Bloggs\\src\\main\\resources\\static\\Uploads";


    public String createCourse(MultipartFile file, @Validated Course course) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String uniqueFilename = generateUniqueFilename(originalFilename);

        String imagePath = FolderToStoreImages + uniqueFilename;
        course.setCoverPage(imagePath);

        try {
            file.transferTo(new File(imagePath));

            courseRepository.save(course);
        } catch (IOException e) {
            // Handle the exception appropriately, e.g., log the error or throw a custom exception
            throw new IOException("Failed to save the image and course: " + e.getMessage(), e);
        }

        return null;
    }

    private String generateUniqueFilename(String originalFilename) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomString = UUID.randomUUID().toString().substring(0, 8);
        return timestamp + "_" + randomString + "_" + originalFilename;
    }


    @PostMapping("/AddCourse")
    public ResponseEntity<String> createCourse(@RequestPart("file")  MultipartFile file,
                                               @RequestPart("Name") String Name,
                                               @RequestPart("Cost") String Cost,
                                                                     String CoverPage)
    {
        System.out.println("Received file: " + file.getOriginalFilename());
        System.out.println("Received name: " + Name);
        System.out.println("Received cost: " + Cost);



            try {
                String uniqueFilename = generateUniqueFilename(file.getOriginalFilename());
                // Configure the image upload path in application.properties
                String imageUploadPath = FolderToStoreImages;
                String imagePath = imageUploadPath + uniqueFilename;

                file.transferTo(new File(imagePath));

                Course course = new Course();
                course.setName(Name);
                course.setCost(Cost);
                course.setCoverPage(imagePath);
                courseRepository.save(course);


                return ResponseEntity.ok("Course created successfully.");

            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create course.");
            }
        }


    }









