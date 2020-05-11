package com.wxl.system.dao;

import org.apache.ibatis.annotations.Mapper;
import com.wxl.system.entity.Teacher;

@Mapper
public interface TeacherDAO {
    void insertTeacher(Teacher teacher);
    Teacher findByTno(String tno);
}
