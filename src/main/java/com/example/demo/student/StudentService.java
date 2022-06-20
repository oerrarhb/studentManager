package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        // check if email is taken
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, Student student) {
        var studentToEdit = getAllStudents().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        if (studentToEdit != null) {
            studentToEdit.setName(student.getName());
            studentToEdit.setEmail(student.getEmail());
            studentToEdit.setGender(student.getGender());
            studentRepository.save(studentToEdit);
        }
    }
}
