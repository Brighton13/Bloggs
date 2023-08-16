package com.bbtechnologies.Bloggs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyCourses {

    @Id
    private  int id;
    private int userID;
    private String Name;
    private String CoverPage;
    private int Cost;

    public MyCourses(int userID, String name, String coverPage, int cost) {

        this.userID = userID;
        Name = name;
        CoverPage = coverPage;
        Cost = cost;
    }
}
