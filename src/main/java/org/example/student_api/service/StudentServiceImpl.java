package org.example.student_api.service;

import org.example.student_api.model.Student;
import org.example.student_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // CreateStudent
    @Override
    public Student CreateStudent(Student student) {
        if (studentRepository.existsById(student.getStudent_id()))
        {
            return null;
        }
        else {
            return studentRepository.save(student);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    @Override
    public Student getStudentByID(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public Student updateStudent(long id, Student student) {

        Student existingStudent= getStudentByID(id);
        if(existingStudent!=null)
        {
            existingStudent.setStudent_name(student.getStudent_name());
            existingStudent.setCollege_name(student.getCollege_name());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhone_number(student.getPhone_number());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setCourse_of_study(student.getCourse_of_study());
            existingStudent.setMajor(student.getMajor());
            existingStudent.setGpa(student.getGpa());
            return studentRepository.save(existingStudent);
        }
        else {
            return null;
        }
    }

    @Override
    public Student partialUpdateStudent(long id, java.util.Map<String, Object> partialStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            partialStudent.forEach((key, value) -> {
                switch (key) {
                    case "student_name":
                        existingStudent.setStudent_name((String) value);
                        break;
                    case "college_name":
                        existingStudent.setCollege_name((String) value);
                        break;
                    case "email":
                        existingStudent.setEmail((String) value);
                        break;
                    case "phone_number":
                        existingStudent.setPhone_number((String) value);
                        break;
                    case "address":
                        existingStudent.setAddress((String) value);
                        break;
                    case "course_of_study":
                        existingStudent.setCourse_of_study((String) value);
                        break;
                    case "major":
                        existingStudent.setMajor((String) value);
                        break;
                    case "gpa":
                        existingStudent.setGpa(((Number) value).doubleValue());
                        break;
                }
            });
            return studentRepository.save(existingStudent);
        }
        return null;
    }


}
