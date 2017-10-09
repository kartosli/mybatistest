package com.qtone.mytest.Service.impl;

import com.qtone.mytest.Mapper.UserTestMapper;
import com.qtone.mytest.Model.UserTest;
import com.qtone.mytest.Model.UserTestExample;
import com.qtone.mytest.Service.ITestUserService;
import com.qtone.mytest.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/22.
 */
@Service
public class ITestUserServiceImpl implements ITestUserService{
    @Autowired
    UserTestMapper userMapper;
    public List<UserTest> findUserList() {
        UserTestExample example = new UserTestExample();
        return userMapper.selectByExample(example);
    }
}
