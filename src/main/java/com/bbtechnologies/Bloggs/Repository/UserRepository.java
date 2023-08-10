package com.bbtechnologies.Bloggs.Repository;

import com.bbtechnologies.Bloggs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
