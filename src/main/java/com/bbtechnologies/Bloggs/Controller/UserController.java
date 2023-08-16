package com.bbtechnologies.Bloggs.Controller;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Model.User;
import com.bbtechnologies.Bloggs.Service.CourseService;
import com.bbtechnologies.Bloggs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;

    @GetMapping("{id}/UserCourses/")
    public List<Course> UserCourses(@PathVariable int id){
        return userService.GetAllUserCourses(id);
    }

    @PostMapping("/addUser")
    public String createUser(User user){
        userService.CreateUser(user);
        return "redirect:/";
    }
}
