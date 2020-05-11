package com.wxl.system.service;

import com.wxl.system.entity.Student;

public interface StudentService {

    //录入学生档案信息
    void insertStudent(Student student);

    Student findBySno(String sno);

}
