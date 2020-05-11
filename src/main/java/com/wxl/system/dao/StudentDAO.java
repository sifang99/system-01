package com.wxl.system.dao;

import com.wxl.system.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDAO {
    //插入学生档案信息
    void insertStudent(Student student);

    Student findBySno(String sno);

}

