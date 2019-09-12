package com.cloud.study.api.controller;

import com.cloud.study.model.dto.HtmlEmailDTO;
import com.cloud.study.model.dto.TextEmailDTO;
import com.google.common.collect.Maps;
import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 18:00
 */
@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    private AsyncEventBus bus;

    @GetMapping("/test")
    public Map<String, Object> map() {
        TextEmailDTO textEmailDTO = new TextEmailDTO();
        textEmailDTO.setTo("1969389528@qq.com");
        textEmailDTO.setContent("test");
        textEmailDTO.setSubject("async job");
        bus.post(textEmailDTO);
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("code", 200);
        map.put("status", "OK");
        return map;
    }
}
