package com.wxl.system.service;

import com.wxl.system.entity.User;

public interface UserService {

    User login(User user);

    //根据用户账号，查询用户角色
    String findRoleByAccount(String account);

    //学生：根据用户账号查询用户姓名
    String findNameByAccountS(String account);

    //教师：根据用户账号查询用户姓名
    String findNameByAccountT(String account);

    //管理员：根据用户账号查询用户姓名
    String findNameByAccountM(String account);

    void changePassword(User user);

}
