package com.cruzny.neorestpsal.registration;

import com.cruzny.neorestpsal.app_user.AppUser;
import com.cruzny.neorestpsal.app_user.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final AppUserRole role;
}
