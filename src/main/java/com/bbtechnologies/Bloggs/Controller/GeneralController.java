package com.bbtechnologies.Bloggs.Controller;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GeneralController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String Index(){
        List<Course> courses = courseService.GetAllCourses();
        return "Index";
    }
}
