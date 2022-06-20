package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Long id)
    {
        studentService.deleteStudent(id);
    }


    @PutMapping("/updateStudent/{id}")
    public void editStudent(@PathVariable("id") Long id, @RequestBody Student student)
    {
        studentService.updateStudent(id,student);
    }

}
