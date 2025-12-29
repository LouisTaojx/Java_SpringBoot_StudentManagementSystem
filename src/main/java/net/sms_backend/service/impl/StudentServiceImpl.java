package net.sms_backend.service.impl;

import lombok.AllArgsConstructor;
import net.sms_backend.dto.StudentDto;
import net.sms_backend.entity.Student;
import net.sms_backend.exception.ResourceNotFoundException;
import net.sms_backend.mapper.StudentMapper;
import net.sms_backend.repository.StudentRepository;
import net.sms_backend.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public StudentDto getStudetnById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student is not exists with given id :" + studentId));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long stundetId, StudentDto updatedStudent) {

        Student student = studentRepository.findById(stundetId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: "+ stundetId)
        );

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        Student updatedStudentObj = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long stundetId) {

        Student student = studentRepository.findById(stundetId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: "+ stundetId)
        );

        studentRepository.deleteById(stundetId);
    }
}
