package com.ly.webapi.controller;

import cicada.authorization.UserAuthorization;
import cicada.core.Ret;

import cicada.core.valid.InsertCheck;
import com.google.common.base.Strings;
import com.ly.bll.dao.AppinfoMapper;
import com.ly.bll.model.Appinfo;
import com.ly.bll.model.AppinfoExample;
import com.ly.bll.unity.ListWithTotal;
import com.ly.bll.model.AppinfoExample.Criteria;
import com.ly.bll.unity.Page;
import com.ly.bll.unity.Tools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("AppInfoController")
@Api(value = "AppInfoController", description = "授权开放的应用")
@UserAuthorization
public class AppInfoController {

    @Autowired
    AppinfoMapper mapper;

    @RequestMapping(value = "/getAppInfos", method = RequestMethod.GET)
    @ApiOperation("获取应用列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageIndex", value = "页码", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "appName", value = "应用名称", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", required = false, paramType = "query", dataType = "string")})
    public Ret<ListWithTotal<Appinfo>> list(@RequestParam(required = true) int pageIndex, @RequestParam(required = false) String startDate,
                                            @RequestParam(required = false) String endDate, @RequestParam(required = false) String appName) {
        int pageSize = Page.getPageSize();
        AppinfoExample example = new AppinfoExample();
        example.setPageNo(pageIndex);
        example.setPageSize(pageSize);

        Criteria criteria = example.or();
        if (!Strings.isNullOrEmpty(appName)) {
            appName = String.format("%s%s%s", "%", appName, "%");

            criteria.andAppNameLike(appName);
        }
        /*if (startDate != null && !startDate.isEmpty()) {

            criteria.andAppCreateDateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null && !endDate.isEmpty()) {
            criteria.andAppCreateDateTimeLessThanOrEqualTo(endDate);
        }*/
        Ret<ListWithTotal<Appinfo>> result = new Ret<>();
        int count = mapper.countByExample(example);
        List<Appinfo> list = mapper.selectByExample(example);
        if (count <= 0) {
            result.setStatus(0);
            result.setData(null);
            result.setMessage("暂无数据");
            return result;
        }
        ListWithTotal<Appinfo> listWithTotal = new ListWithTotal<>();
        listWithTotal.setData(list);
        listWithTotal.setCount(count);

        result.setData(listWithTotal);
        result.setStatus(1);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增申请应用信息")
    public Ret<Boolean> add(HttpServletRequest request, @RequestBody @Validated(value = InsertCheck.class) Appinfo appinfo) {
        Ret<Boolean> result = new Ret<>();
        appinfo.setAppId(Tools.guid());
        appinfo.setAppCreateDateTime(new Date());
        mapper.insert(appinfo);
        result.setStatus(1);
        return result;
    }


}
