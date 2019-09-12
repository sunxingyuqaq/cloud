package com.cloud.study.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.study.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Sunxing Yu
 * @date 2019/9/11 16:41
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
}
