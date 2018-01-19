package cn.name.service.impl;

import cn.name.mapper.UserMapper;
import cn.name.model.User;
import cn.name.model.UserExample;
import cn.name.service.UserService;
import cn.name.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Nominal on 2018/1/18 0018.
 * 微博：@李明易DY
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Integer save(User user) throws Exception {
        //添加唯一激活码
        user.setCode(UUID.randomUUID().toString().replaceAll("-",""));
        //设置账户默认状态 0：未激活
        user.setState(0);
        //通过用户填写的邮箱，发送激活邮件
        MailUtils.sendMail(user.getEmail(),user.getCode());
        return userMapper.insert(user);
    }

    /**
     * 通过code 修改激活状态 0：未激活 1：激活
     *
     * @param user
     * @return
     */
    @Override
    public Integer activate(User user) {
        UserExample userExample=new UserExample();
        //创建sql条件
        userExample.createCriteria().andCodeEqualTo(user.getCode());
        //通过条件查询用户信息
        List<User> list=(List<User>) userMapper.selectByExample(userExample);
        User user2=null;
        for (User user1 : list) {
            //修改查询出来的用户的激活状态 1：激活
            user1.setState(1);
            user2=user1;
        }
        //通过code修改用户状态
        return userMapper.updateByExample(user2,userExample);
    }
}
