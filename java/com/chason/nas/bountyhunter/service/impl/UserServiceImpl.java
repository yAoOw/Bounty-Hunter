package com.chason.nas.bountyhunter.service.impl;

import com.chason.nas.bountyhunter.mapper.UserMapper;
import com.chason.nas.bountyhunter.model.User;
import com.chason.nas.bountyhunter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>description: </p>
 * <p>Date: 2018/5/30</p>
 * <p>modify：</p>
 *
 * @author zhang qq.773935581
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {

      return userMapper.insert(user);
    }
}
