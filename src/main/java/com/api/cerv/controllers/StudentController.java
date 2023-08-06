package com.api.cerv.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.cerv.dtos.StudentRecordDTO;
import com.api.cerv.models.StudentModel;
import com.api.cerv.repositories.AddressRepository;
import com.api.cerv.services.StudentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class StudentController {
  @Autowired
  AddressRepository addressRepository;
  @Autowired
  StudentService studentService;

  @PostMapping("/students")
  public ResponseEntity<StudentModel> saveStudent(@RequestBody @Valid StudentRecordDTO studentRecordDTO) {
    return ResponseEntity.status(HttpStatus.OK).body(studentService.saveStudent(studentRecordDTO));
  }

  @GetMapping("/students")
  public ResponseEntity<List<StudentModel>> getAllStudents() {
    return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Object> getStudentById(@PathVariable(value = "id") UUID id) {
    return studentService.getStudentById(id);
  }

  @PutMapping("/students/{id}")
  public ResponseEntity<Object> updateUserById(
      @PathVariable(value = "id") UUID id,
      @RequestBody @Valid StudentRecordDTO studentRecordDTO) {

    return studentService.updateUserById(id, studentRecordDTO);
  }

  @DeleteMapping("/students/{id}")
  public ResponseEntity<Object> deleteStudent(@PathVariable(value = "id") UUID id) {
    return studentService.deleteStudent(id);
  }

}
