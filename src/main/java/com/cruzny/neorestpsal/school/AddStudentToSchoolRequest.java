package com.cruzny.neorestpsal.school;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Data
public class AddStudentToSchoolRequest {
    private Long id;
    private String emailAddress;

}
