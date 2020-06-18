package com.example.mybatis.controller;

import com.example.mybatis.model.Homework;
import com.example.mybatis.model.Student;
import com.example.mybatis.model.StudentHomework;
import com.example.mybatis.service.StuServiceImpl;
import com.example.mybatis.service.TeaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApiController {
    private final StuServiceImpl StuService;
    private final TeaServiceImpl TeaService;

    @Autowired
    public ApiController(StuServiceImpl StuService, TeaServiceImpl TeaService) {
        this.StuService = StuService;
        this.TeaService = TeaService;
    }

    public void update1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s=req.getParameter("sId");
        long l = Long.parseLong(s);
        List<Homework> list2 = StuService.selectAll3();
        if(null == list2 || list2.size() <= 0){
            req.setAttribute("flag",false);
        }else{
            req.setAttribute("flag",true);
            List<StudentHomework> list3=new ArrayList<StudentHomework>();
            List<Homework> list4=new ArrayList<Homework>();
            for (Homework h : list2){
                StudentHomework sh=StuService.find1(l,h.getId());
                if(sh==null){
                    list4.add(h);
                }else{
                    list3.add(sh);
                }
            }
                req.setAttribute("list3",list3);
                req.setAttribute("list4",list4);
            }
    }

    public void update2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list3 = StuService.selectAll3();
        List<Student> list2=TeaService.selectAll2();
        for (Student s:list2){
            System.out.println(s.getName());
            System.out.println(s.getCreateTime());
        }
        List<StudentHomework> list1=TeaService.selectAll1();

        req.setAttribute("list1",list1);
        req.setAttribute("list2",list2);
        req.setAttribute("list3",list3);
    }

    //登录
    @RequestMapping("/login")
    public void login (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Student> list= StuService.login(req);
        if(null == list || list.size() <= 0){
            req.getRequestDispatcher("/Login.jsp").forward(req,resp);
        }else{
            update1(req,resp);
            req.getRequestDispatcher("/StuSubmit.jsp").forward(req,resp);
        }
    }

    //老师注册
    @RequestMapping("/TRegister")
    public void TeaRegister (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean b=TeaService.addTeacher(req);
        if(b){
            req.getRequestDispatcher("/TeaChoose.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/TeaRegister.jsp").forward(req,resp);
        }
    }

    //老师登录
    @RequestMapping("/Tlogin")
    public void Tealogin (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean b=TeaService.login(req);
        if(b){
            req.getRequestDispatcher("/TeaChoose.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/TeaLogin.jsp").forward(req,resp);
        }

    }

    @RequestMapping("/Search")
    public void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        update2(req,resp);
        req.getRequestDispatcher("/TeaSearch.jsp").forward(req,resp);
    }

    @RequestMapping("/Check")
    public void Check(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String s=req.getParameter("hwId");
        List<Homework>list3 = StuService.selectAll3();
        for (Homework h:list3){
            long l =h.getId();
            List<StudentHomework> list1 = TeaService.find4(l);
            Long n=(long)list1.size();
            boolean b=StuService.editHomework(l,n);
            System.out.println(b);
        }

        update2(req,resp);
        req.getRequestDispatcher("/TeaCheck.jsp").forward(req,resp);
    }

    @RequestMapping("/check")
    public void check (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println(req.getParameter("hwId"));
        req.getRequestDispatcher("/TCheckHomework2.jsp").forward(req,resp);
    }

    public void Check2(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String s=req.getParameter("hwId");
        long l = Long.parseLong(s);
        List<StudentHomework> list1 = TeaService.find4(l);
        if(null == list1 || list1.size() <= 0){
            req.setAttribute("flag",false);
        }else{
            req.setAttribute("flag",true);
            req.setAttribute("list1",list1);
        }

        req.getRequestDispatcher("/TeaCheck2.jsp").forward(req,resp);
    }


    @RequestMapping("/CheckHomework")
    public void checkHomework1 (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String s=req.getParameter("hwId");
        long l = Long.parseLong(s);
        List<StudentHomework> list1 = TeaService.find4(l);

        if(null == list1 || list1.size() <= 0){
            req.setAttribute("flag",false);
        }else{
            req.setAttribute("flag",true);
            req.setAttribute("list1",list1);
        }

        req.getRequestDispatcher("/TeaCheck2.jsp").forward(req,resp);
    }

    @RequestMapping("/CheckHomework2")
    public void checkHomework2 (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/TeaCheck3.jsp").forward(req,resp);
    }

    //作业提交执行
    @RequestMapping("/CheckHomework3")
    public void checkHomework3(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        boolean i=TeaService.editHomework(req);

        //输出结果
        if(i){
            System.out.println("true");

        }else{
            System.out.println("false");
        }
        Check2(req,resp);
    }

    @RequestMapping("/TAdd")
    public void TeaAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        update2(req,resp);
        req.getRequestDispatcher("/TeaAddStudent.jsp").forward(req,resp);
    }

    @RequestMapping("/addStudent")
    public void TeaAddStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        boolean i= TeaService.addStudent(req);
        update2(req,resp);

        //输出结果
        if(i){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        req.getRequestDispatcher("/TeaAddStudent.jsp").forward(req,resp);
    }

    @RequestMapping("/DeleteStudentServlet")
    public void TeaDeleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        boolean j=TeaService.deleteStudent(req);
        update2(req,resp);

        //输出结果
        if(j){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        req.getRequestDispatcher("/TeaDeleteStudent.jsp").forward(req,resp);

    }

    @RequestMapping("/TDelete")
    public void TeaDelete (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        update2(req,resp);
        req.getRequestDispatcher("/TeaDeleteStudent.jsp").forward(req,resp);
    }


    @RequestMapping("/TADDHomework")
    public void TeaAddHomework (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        update2(req,resp);
        req.getRequestDispatcher("/TeaAddHomework.jsp").forward(req,resp);
    }

    @RequestMapping("/HomeworkServlet")
    public void addHomework(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        boolean i=TeaService.addHomework(req);
        update2(req,resp);

        //输出结果
        if(i){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        req.getRequestDispatcher("/TeaAddHomework.jsp").forward(req,resp);
    }


    //学生选择功能界面跳转到作业列表
    @RequestMapping("/submit1")
    public void submit1 (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        update1(req,resp);
        req.getRequestDispatcher("/StuSubmit.jsp").forward(req,resp);
    }

    //跳转到提交界面
    @RequestMapping("/submit2")
    public void submit2 (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/StuSubmit2.jsp").forward(req,resp);
    }

    //执行提交作业
    @RequestMapping("/SubmitHomeworkServlet")
    public void submitHomework(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        boolean j= StuService.deleteStudentHomework(req);
        boolean i = StuService.addHomework(req);

        //输出结果
        if(i && j){
            System.out.println("true");

        }else{
            System.out.println("false");
        }
        update1(req,resp);
        req.getRequestDispatcher("/StuSubmit.jsp").forward(req,resp);
    }




























}
