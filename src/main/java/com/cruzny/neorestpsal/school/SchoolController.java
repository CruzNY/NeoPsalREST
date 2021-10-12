package com.cruzny.neorestpsal.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/school")
public class SchoolController {
    @Autowired
    SchoolServiceImpl schoolServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<String> addSchool(@RequestBody SchoolRequest request){
        schoolServiceImpl.addSchool(request);
        return ResponseEntity.ok(String.format("%s has been added", request.getName()));
    }

    @GetMapping("/get/{id}")
    public School getSchool(@PathVariable Long id){
        return schoolServiceImpl.getSchool(id);
    }

    @GetMapping("/get/all")
    public List<School> getAllSchools(){
        return schoolServiceImpl.getAllSchools();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchool(@PathVariable Long id){
        schoolServiceImpl.deleteSchool(id);
        return ResponseEntity.ok("School Deleted");
    }
    @PostMapping("/addToSchool")
    public ResponseEntity<String> addStudentToSchool(@RequestBody AddStudentToSchoolRequest request){
        schoolServiceImpl.addStudentToSchool(request.getId(), request.getEmailAddress());
        return ResponseEntity.ok("Student Added");
    }
}
