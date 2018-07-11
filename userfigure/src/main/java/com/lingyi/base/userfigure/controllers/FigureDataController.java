package com.lingyi.base.userfigure.controllers;


import com.lingyi.base.userfigure.DoMain.Ret;
import com.lingyi.base.userfigure.DoMain.RetT;
import com.lingyi.base.userfigure.entities.FigureData;
import com.lingyi.base.userfigure.repositores.FigureDataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("FigureData")
public class FigureDataController {

    private static final Logger logger = LoggerFactory.getLogger(FigureDataController.class);

    @Autowired
    FigureDataService figureDataService;


    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/AddUpdateFigureData", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ApiImplicitParam(name = "figureData", value = "画像数据实体", required = true, dataType = "FigureData")
    public Ret AddUpdateFigureData(@RequestBody FigureData figureData) {
        if (figureData == null) return null;
        return figureDataService.addOrUpdateData(figureData);
    }

    @ApiOperation(value = "根据用户编码查询用户画像数据", notes = "查询数据库中某个用户的数据画像数据")
    @RequestMapping(value = "/{userBaseId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ApiImplicitParam(name = "userBaseId", value = "用户编码", paramType = "path", required = true, dataType = "String")
    public RetT<FigureData> GetFigureDataById(@PathVariable String userBaseId) {
        return figureDataService.findByUserBaseId(userBaseId);
    }
}
