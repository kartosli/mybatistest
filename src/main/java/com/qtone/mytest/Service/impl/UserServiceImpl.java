package com.qtone.mytest.Service.impl;

import com.qtone.mytest.Dao.IUserDao;
import com.qtone.mytest.Dao.impl.UserDaoImpl;
import com.qtone.mytest.Model.User;
import com.qtone.mytest.Service.IUserService;

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

}
