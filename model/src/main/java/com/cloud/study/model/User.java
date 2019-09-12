package com.cloud.study.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sunxing Yu
 * @date 2019/9/10 17:50
 */
@Data
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = -5602984744341499419L;

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String name;

    private String address;

    private Integer age;
}
