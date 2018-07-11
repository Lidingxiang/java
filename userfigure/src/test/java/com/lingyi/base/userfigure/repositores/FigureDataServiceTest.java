package com.lingyi.base.userfigure.repositores;

import com.lingyi.base.userfigure.DoMain.Ret;
import com.lingyi.base.userfigure.DoMain.RetT;
import com.lingyi.base.userfigure.entities.FigureData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FigureDataServiceTest {

    @Autowired
    private FigureDataService figureDataService;

    @Test
    public void addOrUpdateData() throws Exception {
        FigureData figureData = new FigureData();
        figureData.setUserBaseId("123");
        figureData.setAttributeTags(new String[]{"11", "22"});
        figureData.setCreateDateTime(new Date());
        figureData.setUpdateDateTime(new Date());
        Ret ret = figureDataService.addOrUpdateData(figureData);
        Assert.assertEquals(ret.getStatus(), 0);
    }

    @Test
    public void findByUserBaseId() throws Exception {

        RetT<FigureData> ret = figureDataService.findByUserBaseId("123");
        Assert.assertEquals(ret.getStatus(), 0);
    }

}