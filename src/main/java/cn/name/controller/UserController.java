package cn.name.controller;

import cn.name.model.User;
import cn.name.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nominal on 2018/1/19 0019.
 * 微博：@李明易DY
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 跳转到注册页面
     * @return
     */
    @GetMapping("to_save")
    public String to_save(){
        return "register";
    }

    /**
     * 注册用户
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("do_save")
    @ResponseBody
    public String do_save(User user) throws Exception  {
        userService.save(user);
        return "注册成功，请查看邮箱，激活账户";
    }

    /**
     * 通过激活码激活账户
     * @param user
     * @return
     */
    @GetMapping("activate")
    @ResponseBody
    public String activate(User user){
        userService.activate(user);
        return "激活成功";
    }
}
