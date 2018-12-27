package com.suntak.demo.service.impl;

import com.suntak.demo.dao.UserDao;
import com.suntak.demo.entity.User;
import com.suntak.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.queryUser();
    }

    @Override
    public User getUserById(int userid) {
        return userDao.getUserById(userid);
    }

    @Override
    public User checkUser(String username, String password) {
        return userDao.checkUser(username,password);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        if(user.getUserid() != null && !"".equals(user.getUserid())){
            user.setRegisterDate(new Date());
            try{
                int effectedNum = userDao.insertUser(user);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("插入用户信息失败！ ");
                }
            }catch (Exception e){
                throw new RuntimeException("插入用户信息失败！ " + e.getMessage());
            }
        }else{
            throw new RuntimeException("用户信息不能为空！ ");
        }
    }

    @Override
    public boolean modifyUser(User user) {
        if(user.getUserid() != null && !"".equals(user.getUserid())){
            user.setRegisterDate(new Date());
            try{
                int effectedNum = userDao.updateUser(user);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("更新用户信息失败！ ");
                }
            }catch (Exception e){
                throw new RuntimeException("更新用户信息失败！ " + e.getMessage());
            }
        }else{
            throw new RuntimeException("用户信息不能为空！ ");
        }
    }

    @Override
    public boolean deleteUser(int userid) {
        try{
            int effectedNum = userDao.deletUser(userid);
            if(effectedNum > 0){
                return true;
            }else{
                throw new RuntimeException("删除用户信息失败！ ");
            }
        }catch (Exception e){
            throw new RuntimeException("删除用户信息失败！ " + e.getMessage());
        }
    }
}
