package com.qtone.mytest.Service;

import com.qtone.mytest.Model.User;

/**
 * Created by Administrator on 2017/9/22.
 */
public interface IUserService {

    public User findUserById(int id);
    public void addUser(User user);
}
