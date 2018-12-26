package com.suntak.demo.dao;

import com.suntak.demo.entity.User;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

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
        User user = new User();
        user.setUserid(3);
        user.setUsername("谢专");
        user.setPassword("ABC");
        SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String registerDate = matter.format(new Date());
        user.setRegisterDate(new Date());
        user.setJob("abc");
        userDao.updateUser(user);

    }

    @Test
    public void deletUser() {
    }
}