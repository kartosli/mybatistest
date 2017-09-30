package com.qtone.mytest.Service.impl;

import com.qtone.mytest.Dao.IUserDao;
import com.qtone.mytest.Dao.impl.UserDaoImpl;
import com.qtone.mytest.Model.User;
import com.qtone.mytest.Model.UserTest;
import com.qtone.mytest.Service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/22.
 */
public class UserServiceImpl  implements IUserService{

    private IUserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
    public void addUser(User user){
        userDao.addUser(user);
    }

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    public int getDataCount() {
        return userDao.getDataCount();
    }

    public List<UserTest> findUserList(Map<String, Object> param) {

        return userDao.findUserList(param);
    }

}
