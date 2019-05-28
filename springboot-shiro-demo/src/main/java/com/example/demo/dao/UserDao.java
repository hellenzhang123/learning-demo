package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.User;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    /**通过username查找用户信息;*/
    public User findByUsername(String username);

  public User save(User user);
}