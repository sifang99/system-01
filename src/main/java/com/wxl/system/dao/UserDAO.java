package com.wxl.system.dao;

import com.wxl.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    //根据用户账号查询用户
    User findByAccount(String account);

    //根据用户账号，查询用户角色
    String findRoleByAccount(String account);

    //学生：根据用户账号查询用户姓名
    String findNameByAccountS(String account);

    //教师：根据用户账号查询用户姓名
    String findNameByAccountT(String account);

    //管理员：根据用户账号查询用户姓名
    String findNameByAccountM(String account);

    //用户修改密码
    void changePassword(User user);

}
