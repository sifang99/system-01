package com.wxl.system.service;

import com.wxl.system.entity.Teacher;

public interface TeacherService {

    //录入教师档案信息
    void insertTeacher(Teacher teacher);
    Teacher findByTno(String tno);
}
