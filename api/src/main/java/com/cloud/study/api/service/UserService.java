package com.cloud.study.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.study.model.User;

import java.util.List;

/**
 * @author Sunxing Yu
 * @date 2019/9/11 16:42
 */
public interface UserService extends IService<User> {

    /**
     * findAll
     * @return s
     */
    List<User> findAll();
}
