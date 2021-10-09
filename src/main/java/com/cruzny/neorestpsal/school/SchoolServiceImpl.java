package com.cruzny.neorestpsal.school;

import com.cruzny.neorestpsal.commons.GenericService;
import com.cruzny.neorestpsal.commons.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl extends GenericServiceImpl<School,Long> implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public CrudRepository<School, Long> getRepository() {
        return schoolRepository;
    }

    public void addSchool(String schoolName, String address, String city, String state){
        School newSchool = new School(schoolName,address,state,city);
        getRepository().save(newSchool);
    }
}
