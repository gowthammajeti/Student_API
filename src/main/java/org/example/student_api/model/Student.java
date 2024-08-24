package org.example.student_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "students")

public class Student {

    @Id
    private  Long student_id;

    @NotNull
    private String student_name;

   @NotNull
    private String college_name;

    @Email
    private String email;

    @NotNull
    private String phone_number;

    @NotNull
    private String address;

    @NotNull
    private String course_of_study;

    @NotNull
    private String major;

    @NotNull
    private double gpa;

}

