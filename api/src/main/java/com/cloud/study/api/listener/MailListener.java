package com.cloud.study.api.listener;

import com.cloud.study.api.service.MailService;
import com.cloud.study.model.dto.HtmlEmailDTO;
import com.cloud.study.model.dto.ImgEmailDTO;
import com.cloud.study.model.dto.TextEmailDTO;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 16:47
 */
@Service
@SuppressWarnings("all")
public class MailListener {

    @Autowired
    private MailService emailService;

    @Autowired
    private AsyncEventBus eventBus;

    @PostConstruct
    public void init(){
        eventBus.register(this);
    }

    /**
     * 线程安全，消费 文本消息
     * @param textEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendTextMail(TextEmailDTO textEmailDTO){
        emailService.sendTextMail(
                textEmailDTO.getTo(),
                textEmailDTO.getSubject(),
                textEmailDTO.getContent()
        );

    }

    /**
     * 线程安全 消费 html消息
     * @param htmlEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendHtmlMail(HtmlEmailDTO htmlEmailDTO){
        try {
            emailService.sendHtmlMail(
                    htmlEmailDTO.getTo(),
                    htmlEmailDTO.getHtmlContent(),
                    htmlEmailDTO.getSubject()
            );
        } catch (MessagingException e) {
            // nothing to do
        }
    }

    /**
     * 线程安全 消费 图文消息
     * @param imgEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendImgMail(ImgEmailDTO imgEmailDTO){
        try {
            emailService.sendImgMail(
                    imgEmailDTO.getTo(),
                    imgEmailDTO.getImgContent(),
                    imgEmailDTO.getSubject(),
                    imgEmailDTO.getRscId(),
                    imgEmailDTO.getImgPath()
            );
        } catch (MessagingException e) {
            // nothing to do
        }
    }

}
