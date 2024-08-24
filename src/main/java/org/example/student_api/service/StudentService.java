package org.example.student_api.service;

import org.example.student_api.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    Student CreateStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByID(long id);
    void deleteStudentById(long id);
    void deleteAllStudents();
    Student updateStudent(long id, Student student);
    Student partialUpdateStudent(long id, Map<String, Object> partialStudent);
}
