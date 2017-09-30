package com.qtone.mytest.Dao.impl;

import com.qtone.mytest.Dao.IUserDao;
import com.qtone.mytest.Mapper.UserMapper;
import com.qtone.mytest.Mapper.UserTestMapper;
import com.qtone.mytest.Model.User;
import com.qtone.mytest.Model.UserTest;
import com.qtone.mytest.Model.UserTestExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements IUserDao{
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private UserMapper mapper;
    public UserDaoImpl() {
        String resource = "mybatis_conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User findUserById(int id) {
        String statement = "userMapper.findUserById";
        User user = (User)session.selectOne(statement, 1);
        return user;
    }
    public void addUser(User user) {
        String statement = "userMapper.addUser";
        session.insert(statement, user);
        session.commit();  //一定要记得commit
    }

    public List<User> findAllUser() {
        return mapper.getAllUsers();
    }

    public int getDataCount() {
        UserTestMapper uTmapper = session.getMapper(UserTestMapper.class);

        UserTestExample example = new UserTestExample();
        UserTestExample.Criteria criteria = example.createCriteria();
        int count = uTmapper.countByExample(example);
        return count;
    }

    public List<UserTest> findUserList(Map<String, Object> param) {
        UserTestMapper uTmapper = session.getMapper(UserTestMapper.class);
        String userName = (String)param.get("username");
        String passWord = (String)param.get("password");

        UserTestExample example = new UserTestExample();
        UserTestExample.Criteria criteria = example.createCriteria();

        if(null!=userName){
            criteria.andUsernameEqualTo(userName);
        }
        if(null!=passWord){
            criteria.andPasswordEqualTo(passWord);

        }
        List<UserTest>list = uTmapper.selectByExample(example);


        return list;
    }


}
