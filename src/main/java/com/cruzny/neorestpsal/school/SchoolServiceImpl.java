package com.cruzny.neorestpsal.school;

import com.cruzny.neorestpsal.commons.GenericService;
import com.cruzny.neorestpsal.commons.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl extends GenericServiceImpl<School,Long> implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

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
}
