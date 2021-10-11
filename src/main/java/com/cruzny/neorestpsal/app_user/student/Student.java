package com.cruzny.neorestpsal.app_user.student;

import com.cruzny.neorestpsal.app_user.AppUser;
import com.cruzny.neorestpsal.app_user.AppUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

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

    public Student(String firstName, String lastName, String email, String password, AppUserRole appUserRole) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setEmail(email);
        super.setPassword(password);
        super.setAppUserRole(appUserRole);
    }
}
