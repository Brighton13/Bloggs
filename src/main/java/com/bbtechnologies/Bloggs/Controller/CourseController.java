package com.bbtechnologies.Bloggs.Controller;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/Admin/Add/Course")
    public String CreateNewCourse(@ModelAttribute Course course){
        courseService.CreateCourse(course);
        return "redirect:/";
    }
}
