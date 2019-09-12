package com.cloud.study.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.study.api.dao.UserDao;
import com.cloud.study.api.service.UserService;
import com.cloud.study.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sunxing Yu
 * @date 2019/9/11 16:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return userDao.selectPage(new Page<>(0,20),queryWrapper).getRecords();
    }
}
