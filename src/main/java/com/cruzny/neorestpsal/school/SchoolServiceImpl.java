package com.cruzny.neorestpsal.school;

import com.cruzny.neorestpsal.app_user.AppUserRepository;
import com.cruzny.neorestpsal.app_user.student.Student;
import com.cruzny.neorestpsal.commons.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl extends GenericServiceImpl<School,Long> implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public CrudRepository<School, Long> getRepository() {
        return schoolRepository;
    }

    public void addSchool(SchoolRequest request){
        School newSchool = new School(request.getName(), request.getStreetAddress(), request.getState(), request.getCity());
        save(newSchool);
    }

    public School getSchool(Long id){
        return get(id);
    }

    public List<School> getAllSchools(){
        return getAll();
    }
    public void deleteSchool(Long id){
        delete(id);
    }
    public void addStudentToSchool(Long schoolId, String studentEmail){
        School school = get(schoolId);
        Student student = (Student) appUserRepository.findByEmail(studentEmail).get();
        save(school);
        System.out.println("Saved School");
        appUserRepository.save(student);
        System.out.println("Saved Student");
    }
}
