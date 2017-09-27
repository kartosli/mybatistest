package com.qtone.mytest.Dao.impl;

import com.qtone.mytest.Dao.IUserDao;
import com.qtone.mytest.Mapper.UserMapper;
import com.qtone.mytest.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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
}
