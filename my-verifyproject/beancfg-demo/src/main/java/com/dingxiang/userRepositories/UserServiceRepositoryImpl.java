package com.dingxiang.userRepositories;

import com.dingxiang.userservicedriver.GetUserInfoRet;
import com.dingxiang.userservicedriver.GetUserInfoStatus;
import com.dingxiang.userservicedriver.UserInfo;
import com.dingxiang.userservicedriver.UserInfoService;
import com.google.common.base.Strings;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class UserServiceRepositoryImpl implements UserServiceRepository {

    /*@Autowired*/
    private UserInfoService.Iface iface;

    public UserServiceRepositoryImpl(UserInfoService.Iface iface) {
        this.iface = iface;
    }

    @Override
    public UserInfo GetUsedInfoById(String userBaseId) throws TException {
        if (Strings.isNullOrEmpty(userBaseId)) return null;
        GetUserInfoRet getUserInfoRet = iface.GetUserInfo(userBaseId);
        if (getUserInfoRet.getStatus() != GetUserInfoStatus.Success) return null;

        UserInfo userInfo = getUserInfoRet.getUserInfo();
        if (null == userInfo) return null;
        return userInfo;
    }
}
