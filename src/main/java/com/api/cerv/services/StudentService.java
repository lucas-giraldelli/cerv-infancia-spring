package com.api.cerv.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.cerv.dtos.StudentRecordDTO;
import com.api.cerv.models.AddressModel;
import com.api.cerv.models.StudentModel;
import com.api.cerv.repositories.StudentRepository;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;
  @Autowired
  AddressService addressService;

  public StudentModel saveStudent(StudentRecordDTO studentRecordDTO) {
    var studentModel = new StudentModel();
    BeanUtils.copyProperties(studentRecordDTO, studentModel);
    return studentRepository.save(studentModel);
  }

  public List<StudentModel> getAllStudents() {
    return studentRepository.findAll();
  }

  public ResponseEntity<Object> getStudentById(UUID id) {
    Optional<StudentModel> student0 = studentRepository.findById(id);
    if (student0.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
    return ResponseEntity.status(HttpStatus.OK).body(student0.get());
  }

  public ResponseEntity<Object> updateUserById(UUID id, StudentRecordDTO studentRecordDTO) {

    Optional<StudentModel> student0 = studentRepository.findById(id);
    if (student0.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
    var studentModel = student0.get();

    /** Logic for address */
    var addressId = studentRecordDTO.address();
    Optional<AddressModel> address0;
    if (addressId != null) {
      address0 = addressService.findById(addressId);
      if (address0.isPresent()) {
        studentModel.setAddress(address0.get());
      }
    } else {
      studentModel.setAddress(null);
    }

    BeanUtils.copyProperties(studentRecordDTO, studentModel);
    return ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(studentModel));
  }

  public ResponseEntity<Object> deleteStudent(UUID id) {
    Optional<StudentModel> student0 = studentRepository.findById(id);
    if (student0.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
    studentRepository.delete(student0.get());
    return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully.");
  }
}
