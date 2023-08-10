package com.bbtechnologies.Bloggs.Service;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Model.User;
import com.bbtechnologies.Bloggs.Repository.CourseRepository;
import com.bbtechnologies.Bloggs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;


    //Creating a course
    public void CreateCourse(Course course){
        courseRepository.save(course);
    }

    //Listing All the courses
    public List<Course> GetAllCourses(){
        return courseRepository.findAll();
    }

    //assigning a course to a user
    public String AddCourseToUser(int course_id, int user_id){
        Course course= courseRepository.findById(course_id).get();
        User user= userRepository.findById(user_id).get();
        List<Course> courseList=user.getCourseList();
        courseList.add(course);
        userRepository.save(user);
        return "redirect:/UserCourses";
    }
}
