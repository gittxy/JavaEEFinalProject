package com.example.mybatis.service;

import com.example.mybatis.model.Student;
import com.example.mybatis.model.StudentHomework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TeaService {
    boolean login(HttpServletRequest req);
    boolean deleteStudent(HttpServletRequest req);
    boolean editHomework(HttpServletRequest req);
    boolean addStudent(HttpServletRequest req);
    boolean addTeacher(HttpServletRequest req);
    void check(HttpServletRequest req, HttpServletResponse resp);
    boolean addHomework(HttpServletRequest req);
    List<Student> selectAll2();
    List<StudentHomework> selectAll1();
    List<StudentHomework> find4(Long homeworkId);


}
