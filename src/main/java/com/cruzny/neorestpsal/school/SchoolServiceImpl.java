package com.cruzny.neorestpsal.school;

import com.cruzny.neorestpsal.app_user.AppUser;
import com.cruzny.neorestpsal.app_user.AppUserRepository;
import com.cruzny.neorestpsal.app_user.AppUserRole;
import com.cruzny.neorestpsal.app_user.AppUserService;
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
    private AppUserService appUserService;

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

    public void addStudentToSchool(Long schoolId, String studentEmail){
        School school = get(schoolId);
//        Student student = appUserRepository.findByEmail(studentEmail).get();
        System.out.println(appUserService.userExists(studentEmail));
        Student student = (Student) appUserService.loadUserByEmail(studentEmail);
        student.getSchoolSet().add(school);
        school.getStudentSett().add(student);
        save(school);
        appUserService.saveUser(student);
        System.out.println(studentEmail+" Added");

    }
}
