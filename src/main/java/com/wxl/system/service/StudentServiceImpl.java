package com.wxl.system.service;

import com.wxl.system.dao.StudentDAO;
import com.wxl.system.dao.TeacherDAO;
import com.wxl.system.entity.Student;
import com.wxl.system.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void insertStudent(Student student){
        studentDAO.insertStudent(student);
    }

    @Override
    public Student findBySno(String sno){return studentDAO.findBySno(sno);}

}
