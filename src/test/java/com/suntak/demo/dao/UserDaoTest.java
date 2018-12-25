package com.suntak.demo.dao;

import com.suntak.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryUser() {
        List<User> userList = userDao.queryUser();
        System.out.println(userList.get(0).getUsername());
        assertEquals(2,userList.size());
    }

    @Test
    public void getUserById() {
        User user = userDao.getUserById(2);
        System.out.println(user.getUsername() + user.getDeptname());
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("猪崽子");
        user.setDeptname("计生部");
        userDao.insertUser(user);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deletUser() {
    }
}