package com.qtone.mytest.Dao;

import com.qtone.mytest.Model.User;

/**
 * Created by Administrator on 2017/9/7.
 */
public interface IUserDao {
    public User findUserById(int id); //查询
    public void addUser(User user); //添加
}