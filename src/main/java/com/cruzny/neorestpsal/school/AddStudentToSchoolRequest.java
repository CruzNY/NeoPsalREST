package com.cruzny.neorestpsal.school;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddStudentToSchoolRequest {
    private Long id;
    private String emailAddress;

}
