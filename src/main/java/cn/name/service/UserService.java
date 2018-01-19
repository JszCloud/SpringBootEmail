package cn.name.service;

import cn.name.model.User;

/**
 * Created by Nominal on 2018/1/18 0018.
 * 微博：@李明易DY
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    Integer save(User user) throws Exception ;

    /**
     * 通过code 修改激活状态 0：未激活 1：激活
     * @param user
     * @return
     */
    Integer activate(User user);
}
