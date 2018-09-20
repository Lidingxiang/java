package com.ly.Services;

import com.google.common.base.Strings;
import com.ly.bll.dao.AppinfoMapper;
import com.ly.bll.model.Appinfo;
import com.ly.driver.AppInfo;
import com.ly.driver.GetAppInfoRet;
import com.ly.driver.GetAppInfoStatus;
import com.ly.driver.OAth2AppInfoService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService implements OAth2AppInfoService.Iface {

    @Autowired
    AppinfoMapper mapper;

    @Override
    public GetAppInfoRet GetAppInfo(String userBaseId) throws TException {
        GetAppInfoRet getAppInfoRet = new GetAppInfoRet();
        if (Strings.isNullOrEmpty(userBaseId)) {
            getAppInfoRet.setStatus(GetAppInfoStatus.InvalidUserBaseId);
            return getAppInfoRet;
        }
        Appinfo appinfo = mapper.selectByPrimaryKey("ce0e4e2450c0414f9f9c30848e7621dd");
        if (null == appinfo) {
            getAppInfoRet.setStatus(GetAppInfoStatus.NoExist);
            return getAppInfoRet;
        } else {
            getAppInfoRet.setStatus(GetAppInfoStatus.Success);
            AppInfo tmpTransfer = new AppInfo();
            tmpTransfer.appId = appinfo.getAppId();
            tmpTransfer.appKey = appinfo.getAppKey();
            tmpTransfer.appName = appinfo.getAppName();
            tmpTransfer.appSecret = appinfo.getAppSecret();
            tmpTransfer.cancelCallBackUrl = appinfo.getCancelCallBackUrl();
            tmpTransfer.callBackUrl = appinfo.getCallBackUrl();

            getAppInfoRet.setAppinfo(tmpTransfer);
            return getAppInfoRet;
        }
    }
}
