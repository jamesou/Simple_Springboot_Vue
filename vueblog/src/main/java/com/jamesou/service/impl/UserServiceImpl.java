package com.jamesou.service.impl;

import com.jamesou.entity.User;
import com.jamesou.mapper.UserMapper;
import com.jamesou.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author JamesOu
 * @since 2020-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
