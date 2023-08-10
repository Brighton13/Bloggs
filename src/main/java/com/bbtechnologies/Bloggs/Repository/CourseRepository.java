package com.bbtechnologies.Bloggs.Repository;

import com.bbtechnologies.Bloggs.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
