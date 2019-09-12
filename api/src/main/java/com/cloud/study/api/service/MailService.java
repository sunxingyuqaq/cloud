package com.cloud.study.api.service;

import javax.mail.MessagingException;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 16:27
 */
public interface MailService {

    /**
     * sendTextMail
     * @param to
     * @param subject
     * @param content
     */
    void sendTextMail(String to, String subject, String content);

    /**
     * sendHtmlMail
     * @param to
     * @param htmlContent
     * @param subject
     * @throws MessagingException e
     */
    void sendHtmlMail(String to, String htmlContent, String subject) throws MessagingException;
    
    /**
     * sendImgMail
     * @param to
     * @param imgContent
     * @param subject
     * @param rscId
     * @param imgPath
     * @throws MessagingException e
     */
    void sendImgMail(String to, String imgContent, String subject, String rscId, String imgPath) throws MessagingException;

    /**
     * sendAttachMail
     * @param to
     * @param subject
     * @param fileName
     * @param filePath
     * @throws MessagingException e
     */
    void sendAttachMail(String to,String subject,String text,String fileName,String filePath) throws MessagingException;
}
