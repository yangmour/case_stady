package com.atguigu.syt.user.service;

import com.atguigu.syt.model.user.UserInfo;
import com.atguigu.syt.vo.user.UserAuthVo;
import com.atguigu.syt.vo.user.UserInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    int userAuth(Long userId, UserAuthVo userAuthVo);

    UserInfo getUserInfoByUserId(Long userId);

    Page<UserInfo> getList(Integer pageNum, Integer pageSize, UserInfoQueryVo userInfoService);

    void bindPhone(Long userId, String phone, String code);
}
