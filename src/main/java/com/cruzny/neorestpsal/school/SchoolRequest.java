package com.cruzny.neorestpsal.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SchoolRequest {
    private String name;
    private String streetAddress;
    private String state;
    private String city;
}
