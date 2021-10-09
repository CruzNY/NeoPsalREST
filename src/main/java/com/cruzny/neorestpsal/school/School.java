package com.cruzny.neorestpsal.school;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public School(String schoolName, String streetAddress, String state, String city){
        this.schoolName = schoolName;
        this.streetAddress = streetAddress;
        this.state = state;
        this.city = city;
    }
    // Other school related information.
}
