package net.sms_backend.service;

import net.sms_backend.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudetnById(Long studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long stundetId, StudentDto updatedStudent);

    void deleteStudent(Long stundetId);
}
