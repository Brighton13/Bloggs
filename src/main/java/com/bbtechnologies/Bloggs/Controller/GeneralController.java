package com.bbtechnologies.Bloggs.Controller;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Model.MyCourses;
import com.bbtechnologies.Bloggs.Model.User;
import com.bbtechnologies.Bloggs.Repository.CourseRepository;
import com.bbtechnologies.Bloggs.Repository.MyCourseRepository;
import com.bbtechnologies.Bloggs.Service.CourseService;
import com.bbtechnologies.Bloggs.Service.UserService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;



@Controller
public class GeneralController {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MyCourseRepository myCourseRepository;
    @GetMapping("/")
    public ModelAndView Index(){
        ModelAndView modelAndView=new ModelAndView("Index");
        List<User> users=userService.getAllUsers();
        List<Course> courses = courseService.GetAllCourses();
        modelAndView.addObject("user",users);
        modelAndView.addObject("course",courses);
        return modelAndView;
        //return new ModelAndView("Index","course",courses);
    }

    @GetMapping("/Add_Course")
    public String AddCourse(){
        return "AddCourse";
    }

    @GetMapping("/AddUser")
    public String addUser(){
        return "CreateUser";
    }

    @GetMapping("/RegisteredCourses")// links
    public ModelAndView MyCourse(){
        ModelAndView modelAndView=new ModelAndView("MyCourses");
        List<User> users=userService.getAllUsers();
        List<Course> courses = courseService.GetAllCourses();
        List<MyCourses>myCoursesList=myCourseRepository.findAll();


        modelAndView.addObject("user",users);
        modelAndView.addObject("course",courses);
        modelAndView.addObject("mycourse",myCoursesList);
        return modelAndView;
        //return new ModelAndView("Index","course",courses);
    }






}
