package com.cloud.study.consumer.controller;

import com.cloud.study.consumer.service.UserService;
import com.cloud.study.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 11:22
 */
@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public List<User> findAll(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = provider.get(0);
        log.info("host is {} --- port is {}",serviceInstance.getHost(),serviceInstance.getPort());
        String url = "http://PROVIDER/api/user/all";
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
        }).getBody();
    }

    @GetMapping("all-feign")
    public List<User> findAllByFeign(){
        return userService.findAll();
    }
}
