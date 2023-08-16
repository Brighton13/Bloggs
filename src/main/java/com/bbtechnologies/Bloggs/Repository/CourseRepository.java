package com.bbtechnologies.Bloggs.Repository;

import com.bbtechnologies.Bloggs.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByIdIn(Collection<Integer> ids);
}
