package com.wxl.system.controller;

import com.wxl.system.entity.Result;
import com.wxl.system.entity.Teacher;
import com.wxl.system.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
@CrossOrigin //允许跨域
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //录入教师档案信息
    @PostMapping("insertTeacher")
    public Result insertTeacher(@RequestBody Teacher teacher){
        Result result = new Result();
        log.info("teacher:"+teacher);
        try {
            teacherService.insertTeacher(teacher);
            result.setMsg("成功录入教师档案信息！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("未成功录入教师档案信息！");
        }
        return result;
    }

    @GetMapping("findByTno")
    public Teacher findByTno(String tno){
        return teacherService.findByTno(tno);
    }



}
