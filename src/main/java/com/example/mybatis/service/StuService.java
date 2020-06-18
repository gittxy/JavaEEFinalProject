package com.example.mybatis.service;

import com.example.mybatis.model.Homework;
import com.example.mybatis.model.Student;
import com.example.mybatis.model.StudentHomework;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StuService {

    List<Student> login(HttpServletRequest req);
    boolean addHomework(HttpServletRequest req);
    List<Homework> selectAll3();
    StudentHomework find1(Long studentId, Long homeworkId);
    boolean editHomework(Long homeworkId, Long num);
    boolean deleteStudentHomework(HttpServletRequest req);

}
