package com.bbtechnologies.Bloggs.Service;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Model.User;
import com.bbtechnologies.Bloggs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Course> GetAllUserCourses(int id){
        User user =userRepository.findById(id).get();
        return user.getCourseList();
    }
}
