package com.bbtechnologies.Bloggs.Repository;

import com.bbtechnologies.Bloggs.Model.MyCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyCourseRepository extends JpaRepository<MyCourses,Integer> {

}
