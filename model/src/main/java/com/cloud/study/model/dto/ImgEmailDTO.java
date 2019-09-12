package com.cloud.study.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 16:54
 */
@Data
public class ImgEmailDTO implements Serializable {

    private String to;
    private String imgContent;
    private String subject;
    private String rscId;
    private String imgPath;
}
