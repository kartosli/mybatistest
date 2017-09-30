package com.qtone.mytest.Dao;

import com.qtone.mytest.Model.User;
import com.qtone.mytest.Model.UserTest;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/7.
 */
public interface IUserDao {
    public User findUserById(int id); //查询
    public void addUser(User user); //添加
    public List<User> findAllUser();//查找所有用户
    public int getDataCount();
    public List<UserTest> findUserList(Map<String,Object> param);//条件查询
}