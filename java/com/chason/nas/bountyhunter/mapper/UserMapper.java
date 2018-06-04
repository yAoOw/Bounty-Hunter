package com.chason.nas.bountyhunter.mapper;

import com.chason.nas.bountyhunter.model.User;

import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Set<User> selectByKey(User user);
}