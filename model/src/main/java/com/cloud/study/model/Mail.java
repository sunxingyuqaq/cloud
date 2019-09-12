package com.cloud.study.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 16:29
 */
@NoArgsConstructor
@Data
public class Mail implements Serializable {

    private static final long serialVersionUID = 769325088384660852L;

    private String from;

    private String to;

    private String content;

    private String subject;
}
