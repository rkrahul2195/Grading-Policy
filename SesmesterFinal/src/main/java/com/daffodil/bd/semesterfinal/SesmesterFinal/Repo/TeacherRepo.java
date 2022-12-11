package com.daffodil.bd.semesterfinal.SesmesterFinal.Repo;

import com.daffodil.bd.semesterfinal.SesmesterFinal.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
    public Integer countById(Integer id);
}
