package com.chason.nas.bountyhunter.service;

import com.chason.nas.bountyhunter.model.ResponseModel;
import com.chason.nas.bountyhunter.model.User;

/**
 * <p>description: </p>
 * <p>Date: 2018/5/30</p>
 * <p>modify：</p>
 *
 * @author zhang qq.773935581
 **/
public interface UserService {

    int addUser(User user);

    ResponseModel loginUser(User user);

}
