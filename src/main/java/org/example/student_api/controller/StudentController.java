package org.example.student_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.student_api.model.Student;
import org.example.student_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//age= 30
//age=40
@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:5174")
@Tag(name = "Student Management System", description = "Operations pertaining to student in Student Management System")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Create a new student record")
    @PostMapping
    public String createStudent(@RequestBody Student student) {
        Student createStudent = studentService.CreateStudent(student);
        if (createStudent == null) {
            return "Student record already exists";
        } else {
            return "Student record created";
        }
    }

    @Operation(summary = "Get all student records")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get a student record by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable long id) {
        Student studentById = studentService.getStudentByID(id);
        if (studentById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found");
        } else {
            return ResponseEntity.ok(studentById);
        }
    }

    @Operation(summary = "Delete a student record by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id) {
        Student studentById = studentService.getStudentByID(id);
        if (studentById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found");
        } else {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok("Student record deleted");
        }
    }

    @Operation(summary = "Delete all student records")
    @DeleteMapping
    public String deleteAllStudents() {
        studentService.deleteAllStudents();
        return "All student records deleted";
    }

    @Operation(summary = "Update a student record by ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found");
        } else {
            return ResponseEntity.ok("Student record updated");
        }
    }

    @Operation(summary = "Partially update a student record by ID")
    @PatchMapping("/{id}")
    public ResponseEntity<String> partialUpdateStudent(@PathVariable long id, @RequestBody Map<String, Object> partialStudent) {
        Student updatedStudent = studentService.partialUpdateStudent(id, partialStudent);
        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found");
        } else {
            return ResponseEntity.ok("Student record updated");
        }
    }
}
