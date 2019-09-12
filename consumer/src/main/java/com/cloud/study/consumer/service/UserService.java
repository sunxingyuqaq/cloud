package com.cloud.study.consumer.service;

import com.cloud.study.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 14:50
 */
@Component
@FeignClient("provider")
public interface UserService {

    /**
     * findAll
     * @return l
     */
    @GetMapping("/api/user/all")
    List<User> findAll();
}
