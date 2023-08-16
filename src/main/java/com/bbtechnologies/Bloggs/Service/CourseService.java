package com.bbtechnologies.Bloggs.Service;

import com.bbtechnologies.Bloggs.Model.Course;
import com.bbtechnologies.Bloggs.Model.MyCourses;
import com.bbtechnologies.Bloggs.Model.User;
import com.bbtechnologies.Bloggs.Repository.CourseRepository;
import com.bbtechnologies.Bloggs.Repository.MyCourseRepository;
import com.bbtechnologies.Bloggs.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MyCourseRepository myCourseRepository;

    String FolderToStoreImages="C:\\Users\\F I L I M LIGHTS CW\\Desktop\\java projects\\Bloggs\\src\\main\\resources\\static\\Uploads";

    private String generateUniqueFilename(String originalFilename) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomString = UUID.randomUUID().toString().substring(0, 8);
        return timestamp + "_" + randomString + "_" + originalFilename;
    }


    //Creating a course
   public void CreateCourse(@RequestParam MultipartFile img,String Name, int Cost){
        Course course= new Course();
        course.setName(Name);
        course.setCost(Cost);
        course.setCoverPage(img.getOriginalFilename());
        Course courses=courseRepository.save(course);

        if(courses!=null)
        {
            try{
            File saveImage=new ClassPathResource("static/Uploads").getFile();
               Path path= Paths.get(saveImage.getAbsolutePath() + File.separator+img.getOriginalFilename());
               System.out.println(path);
                Files.copy(img.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //Listing All the courses
    public List<Course> GetAllCourses(){
        return courseRepository.findAll();
    }

    //assigning a course to a user
    public String AddCourseToUser(int course_id, int user_id, HttpSession session){

        Course course= courseRepository.findById(course_id).get();
        User user= userRepository.findById(user_id).get();
       Optional<MyCourses> my= myCourseRepository.findById(course_id);
        try{
            if(my.isEmpty())
            {
                MyCourses myCourses = new MyCourses();
                myCourses.setId(course_id);
                myCourses.setUserID(user_id);
                myCourses.setName(course.getName());
                myCourses.setCoverPage(course.getCoverPage());
                myCourses.setCost(course.getCost());
                myCourseRepository.save(myCourses);

            }
            else
            {
                session.setAttribute("msg","Course Already Bought");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "redirect:/RegisteredCourses";
    }


    public void DeleteCourseById(int Id){
        courseRepository.deleteById(Id);
    }

    public void DeleteMyCourseById(int Id){
        myCourseRepository.deleteById(Id);
    }


}
