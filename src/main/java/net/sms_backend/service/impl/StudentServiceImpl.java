package net.sms_backend.service.impl;

import lombok.AllArgsConstructor;
import net.sms_backend.dto.StudentDto;
import net.sms_backend.entity.Student;
import net.sms_backend.mapper.StudentMapper;
import net.sms_backend.repository.StudentRepository;
import net.sms_backend.service.StudentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStundet(studentDto);
        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);
    }
}
