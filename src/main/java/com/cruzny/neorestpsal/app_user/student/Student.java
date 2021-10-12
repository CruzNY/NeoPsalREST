package com.cruzny.neorestpsal.app_user.student;

import com.cruzny.neorestpsal.app_user.AppUser;
import com.cruzny.neorestpsal.app_user.AppUserRole;
import com.cruzny.neorestpsal.school.School;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Student extends AppUser {
    private String grade;
    private Integer age;
    private Date dayOfBirth;
    private Integer totalAppereances = 0;
    private Integer totalYellowCards = 0;
    private Integer totalRedCards = 0;
    private String prefferedFoot;

    @ManyToMany
    @JoinTable(
            name = "school_students",
            joinColumns  = @JoinColumn(name = "student_id"),
            inverseJoinColumns  = @JoinColumn(name = "school_id")
    )
    private Set<School> schoolSet = new HashSet<>();

    public Student(String firstName, String lastName, String email, String password, AppUserRole appUserRole) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setEmail(email);
        super.setPassword(password);
        super.setAppUserRole(appUserRole);
    }
}
