package com.bbtechnologies.Bloggs.Controller;


import com.bbtechnologies.Bloggs.Repository.CourseRepository;
import com.bbtechnologies.Bloggs.Service.CourseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;





@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

//        @PostMapping("/AddCourse")
//        public String addCourse( MultipartFile file,
//                             String Name,
//                             String Cost,
//                            String CoverPage){
//        courseService.createCourse(file,Name,Cost,CoverPage);
//        return "redirect:/";
//        }
@PostMapping("/AddCourse")
public String addCourse( MultipartFile file,String Name, int Cost)
{
    courseService.CreateCourse(file,Name,Cost);
    return "redirect:/";
}



        @GetMapping("/deleteCourse/{id}")
        public String DeleteCourse(@PathVariable int id){
        courseService.DeleteCourseById(id);
        return "redirect:/";
        }
    @GetMapping("/deleteMyCourse/{id}")
    public String DeleteMyCourse(@PathVariable int id){
        courseService.DeleteMyCourseById(id);
        return "redirect:/RegisteredCourses";
    }

        @RequestMapping("/{user_id}/Add_to_My_courses/{id}")
        public String addingCourseToUser(@PathVariable("id") int course_id,
                                         @PathVariable("user_id") int id, HttpSession session){
        courseService.AddCourseToUser(course_id,id,session);
        return "redirect:/RegisteredCourses";
        }


    }









