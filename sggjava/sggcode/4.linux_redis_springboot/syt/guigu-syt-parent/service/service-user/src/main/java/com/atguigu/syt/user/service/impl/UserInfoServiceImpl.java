package com.atguigu.syt.user.service.impl;

import com.atguigu.syt.cmn.client.DictFeignClient;
import com.atguigu.syt.enums.AuthStatusEnum;
import com.atguigu.syt.enums.DictTypeEnum;
import com.atguigu.syt.enums.UserStatusEnum;
import com.atguigu.syt.model.user.UserInfo;
import com.atguigu.syt.user.mapper.UserInfoMapper;
import com.atguigu.syt.user.service.UserInfoService;
import com.atguigu.syt.vo.user.UserAuthVo;
import com.atguigu.syt.yun.client.FileFeignClient;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-07
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private DictFeignClient dictFeignClient;

    @Autowired
    private FileFeignClient fileFeignClient;

    @Override
    public UserInfo getUserInfoByOpenId(String openid) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public int userAuth(Long userId, UserAuthVo userAuthVo) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        BeanUtils.copyProperties(userAuthVo, userInfo);
        userInfo.setAuthStatus(AuthStatusEnum.AUTH_RUN.getStatus());

        //信息更新
        return baseMapper.updateById(userInfo);
    }

    @Override
    public UserInfo getUserInfoByUserId(Long userId) {
        UserInfo userInfo = baseMapper.selectById(userId);
        packInfo(userInfo);
        return userInfo;
    }

    public void packInfo(UserInfo userInfo) {
        //封装用户状态、认证状态、证件类型信息
        Integer authStatus = userInfo.getAuthStatus();
        if (authStatus.intValue() != AuthStatusEnum.NO_AUTH.getStatus().intValue()) {
            String certificatesTypeString = dictFeignClient.getHostName(DictTypeEnum.CERTIFICATES_TYPE.getDictTypeId(), userInfo.getCertificatesType());
//            String certificatesTypeString = dictFeignClient.getHostName(2L, new String("1"));
            userInfo.getParam().put("certificatesTypeString", certificatesTypeString);
        }

        String authStatusString = AuthStatusEnum.getStatusNameByStatus(authStatus);
        userInfo.getParam().put("authStatusString", authStatusString);
        userInfo.getParam().put("statusString", UserStatusEnum.getStatusNameByStatus(userInfo.getStatus()));
        String previewUrl = fileFeignClient.getPreviewUrl(userInfo.getCertificatesUrl());
        userInfo.getParam().put("previewUrl", previewUrl);
    }
}
