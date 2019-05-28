package com.example.demo.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.sevice.UserService;

/**
*
* @author zhangyuxuan
* @date 2019年5月23日
*/
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDao userInfoDao;

  @Override
  public User findByUsername(String username) {
    System.out.println("UserInfoServiceImpl.findByUsername()");
    return userInfoDao.findByUsername(username);
  }

  @Override
  public User save(User user) {
    return userInfoDao.save(user);
  }

}
