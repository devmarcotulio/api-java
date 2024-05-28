package com.devmarcotulio.api.repositories;

import com.devmarcotulio.api.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByName(String name);
}
