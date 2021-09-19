package com.pwcjava.repository;

import com.pwcjava.models.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository <Departments, Long> {

}
