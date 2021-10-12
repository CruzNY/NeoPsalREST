package com.cruzny.neorestpsal.school;

import com.cruzny.neorestpsal.app_user.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class School {
    @Id
    @SequenceGenerator(
            name = "school_sequence",
            sequenceName = "school_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "school_sequence"
    )
    private Long id;
    private String schoolName;
    private String streetAddress;
    private String state;
    private String city;

    @ManyToMany(mappedBy = "schoolSet")
    private Set<Student> studentSett = new HashSet<>();

    public School(String schoolName, String streetAddress, String state, String city){
        this.schoolName = schoolName;
        this.streetAddress = streetAddress;
        this.state = state;
        this.city = city;
    }
    // Other school related information.
}
