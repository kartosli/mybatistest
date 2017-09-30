package com.qtone.mytest.Service;

import com.qtone.mytest.Model.User;
import com.qtone.mytest.Model.UserTest;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/22.
 */
public interface IUserService {

    public User findUserById(int id);
    public void addUser(User user);
    public List<User> findAllUser();
    public int getDataCount();
    public List<UserTest> findUserList(Map<String, Object> param);
}
