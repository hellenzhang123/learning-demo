package com.example.demo.sevice;

import com.example.demo.model.User;


public interface UserService {
  public User findByUsername(String userName);

  public User save(User user);
}