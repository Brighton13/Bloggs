package com.bbtechnologies.Bloggs.Controller;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Repository.CourseRepository;
import com.bbtechnologies.Bloggs.Service.CourseService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class GeneralController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping("/")
    public ModelAndView Index(){
        List<Course> courses = courseService.GetAllCourses();
        return new ModelAndView("Index","course",courses);
    }


    @GetMapping("/Add_Course")
    public String AddCourse(){
        return "AddCourse";
    }






}
