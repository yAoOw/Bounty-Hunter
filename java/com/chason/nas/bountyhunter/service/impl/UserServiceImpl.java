package com.chason.nas.bountyhunter.service.impl;

import com.chason.nas.bountyhunter.enums.ResponseEnum;
import com.chason.nas.bountyhunter.mapper.UserMapper;
import com.chason.nas.bountyhunter.model.ResponseModel;
import com.chason.nas.bountyhunter.model.User;
import com.chason.nas.bountyhunter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * <p>description: </p>
 * <p>Date: 2018/5/30</p>
 * <p>modify：</p>
 *
 * @author zhang qq.773935581
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        log.info("addUser");
        Optional<Set<User>> checkUser = Optional.ofNullable(userMapper.selectByKey(user));
        if(checkUser.isPresent()&& checkUser.get().size()>0&&!user.isNullObj()){
            return 0;
        }
        return userMapper.insert(user);

    }

    @Override
    public ResponseModel loginUser(User user) {
        ResponseModel model = new ResponseModel();
        log.info("loginUser");
        Optional<Set<User>> loginUser = Optional.ofNullable(userMapper.selectByKey(user));
        if(loginUser.isPresent()&& loginUser.get().size()!=1){
            model.setCode(ResponseEnum.FAILED.getCode());
            model.setDesc(ResponseEnum.FAILED.getDesc());
            return model;
        }
        model.setCode(ResponseEnum.SUCCESS.getCode());
        model.setDesc(ResponseEnum.SUCCESS.getDesc());
        return model;
    }
}
