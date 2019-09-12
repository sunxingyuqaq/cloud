package com.cloud.study.provider.controller;

import com.cloud.study.api.service.UserService;
import com.cloud.study.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Sunxing Yu
 * @date 2019/9/10 18:10
 */
@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/all")
    public List<User> findAll(HttpServletRequest request) {
        log.info("url is :{} ",request.getRequestURL());
        log.info("当前提供服务的端口是【{}】",port);
        return userService.findAll();
    }
}
