package com.api.cerv.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cerv.models.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, UUID> {

}
