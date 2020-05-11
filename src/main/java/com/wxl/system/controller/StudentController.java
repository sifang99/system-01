package com.wxl.system.controller;

import com.wxl.system.entity.Result;
import com.wxl.system.entity.Student;
import com.wxl.system.entity.Teacher;
import com.wxl.system.service.StudentService;
import com.wxl.system.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@CrossOrigin //允许跨域
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("findBySno")
    public Student findBySno(String sno){
        log.info("学生信息查询："+sno);
        return studentService.findBySno(sno);
    }

    //录入教师档案信息
    @PostMapping("insertStudent")
    public Result insertStudent(@RequestBody Student student){
        Result result = new Result();
        try {
            studentService.insertStudent(student);
            result.setMsg("成功录入学生档案信息！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("未成功录入学生档案信息！");
        }
        return result;
    }
}
