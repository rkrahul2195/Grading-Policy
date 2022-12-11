package com.daffodil.bd.semesterfinal.SesmesterFinal.Service;

import com.daffodil.bd.semesterfinal.SesmesterFinal.Entity.Teacher;
import com.daffodil.bd.semesterfinal.SesmesterFinal.Repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private TeacherRepo teacherRepo;

    public List<Teacher> teacherList(){
        return teacherRepo.findAll();
    }
    public Teacher get(Integer id) throws TeacherNotFoundException {
        Optional<Teacher> result=teacherRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new TeacherNotFoundException("no user in this ID"+id);
    }

    }


