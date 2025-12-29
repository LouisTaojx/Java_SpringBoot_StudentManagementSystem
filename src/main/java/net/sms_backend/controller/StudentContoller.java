package net.sms_backend.controller;

import lombok.AllArgsConstructor;
import net.sms_backend.dto.StudentDto;
import net.sms_backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentContoller {

    private StudentService studentService;

    // Build add Student REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //Build Get Student REST API
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto = studentService.getStudetnById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    //Build get All students REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStundet(@PathVariable("id") Long studentId,
                                                    @RequestBody StudentDto updatedStudent){
        StudentDto studentDto= studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(studentDto);
    }

    //Bild delete Student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
