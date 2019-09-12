package com.cloud.study.api;

import com.cloud.study.api.dao.UserDao;
import com.cloud.study.api.service.UserService;
import com.cloud.study.model.User;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Sunxing Yu
 * @date 2019/9/11 17:09
 */
@Slf4j
@MapperScan("com.cloud.study.api.dao")
@SpringBootApplication
public class ApiApplication {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class,args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            User build = new User();
            build.setAge(12);
            build.setName("tomcat");
            build.setAddress("green house");
            userDao.insert(build);
            log.info("id is【{}】",build.getId());
            Assert.notNull(build.getId(),"not null");
            List<User> all = userService.findAll();
            all.forEach(System.out::println);
        };
    }
}
