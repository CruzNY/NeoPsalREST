package com.cruzny.neorestpsal.app_user.admin;

import com.cruzny.neorestpsal.app_user.AppUser;
import com.cruzny.neorestpsal.app_user.AppUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Admin extends AppUser {
    public Admin(String firstName, String lastName, String email, String password, AppUserRole appUserRole) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setEmail(email);
        super.setPassword(password);
        super.setAppUserRole(appUserRole);
    }
}
