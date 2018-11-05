package com.my.sample.mybatis.service.impl;

import com.my.sample.mybatis.entity.po.User;
import com.my.sample.mybatis.dao.mapper.UserMapper;
import com.my.sample.mybatis.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shiyongbiao
 * @since 2018-11-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
