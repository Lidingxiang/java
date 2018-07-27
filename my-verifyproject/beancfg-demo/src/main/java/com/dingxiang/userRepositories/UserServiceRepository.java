package com.dingxiang.userRepositories;

import com.dingxiang.userservicedriver.UserInfo;
import org.apache.thrift.TException;

public interface UserServiceRepository {

    UserInfo GetUsedInfoById(String userBaseId) throws TException;
}
