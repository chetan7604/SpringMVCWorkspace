package com.chetan.SpringMvcCrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chetan.SpringMvcCrud.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
