package com.atguigu.syt.user.service;

import com.atguigu.syt.model.user.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-07
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getUserInfoByOpenId(String openid);
}
