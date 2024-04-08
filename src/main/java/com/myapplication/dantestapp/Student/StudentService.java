package com.myapplication.dantestapp.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private static StudentRepository studentRepository;

@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public static void addNewStudent(Student student) {
        Optional<Student>studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email already in use");
        }
        studentRepository.save(student);



    }

    public static List<Student> getstudents() {
    studentRepository.findAll();
        return null;
    }

    public static void deleteStudent(long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
        throw new IllegalStateException("student with id " + studentId + " does not exist");
    }
    studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

    Student student = studentRepository.findById(studentId).
            orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

    if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)) {
        student.setName(name);
    }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), name)) {
           Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
           if (studentOptional.isPresent()) {
           throw new IllegalStateException("email already in use");}
        }
        studentRepository.save(student);
    }

}
