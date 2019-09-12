package com.cloud.study.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 16:56
 */
@Data
public class TextEmailDTO implements Serializable {

    private String to;
    private String subject;
    private String content;
}
