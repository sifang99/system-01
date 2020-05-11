package com.wxl.system.controller;

import com.wxl.system.entity.Result;
import com.wxl.system.entity.User;
import com.wxl.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
@CrossOrigin //允许跨域
@Slf4j

public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping("login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        Result result = new Result();
        log.info("user:" + user);
        try {
            User userDB = userService.login(user);
            //通过账号获取用户角色
            String role = userService.findRoleByAccount(user.getAccount());
            log.info("role:" + role);

            String username;

            //根据用户角色，查询表，获取用户姓名
            if(role.equals("3")){
                username = userService.findNameByAccountM(user.getAccount());
                log.info("用户名:" + username);
            } else if(role.equals("2")){
                username = userService.findNameByAccountT(user.getAccount());
            }else{
                username = userService.findNameByAccountS(user.getAccount());
            }

            result.setRole(role);
            result.setUsername(username);

            //登录成功之后保存用户的标记,应该用redis,还没学，智能这样
            request.getServletContext().setAttribute(userDB.getAccount(), userDB);
            //返回用户的账号，以便其他接口的验证，前台数据存放在localstorage里面
            result.setMsg("登录成功！").setUser_account(userDB.getAccount());

            log.info("result:" + result);

        } catch (Exception e) {
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    //用户修改密码
    @PostMapping("changePassword")
    public Result changePassword(@RequestBody User user){
        Result result = new Result();
        try {

            log.info("userpasword" + user.getPassword());



            userService.changePassword(user);
            result.setMsg("密码修改成功！");
        }catch(Exception e){
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    //管理员录入教师档案信息


}
