package com.lingyi.base.userfigure.repositores;

import com.lingyi.base.userfigure.DoMain.Ret;
import com.lingyi.base.userfigure.DoMain.RetT;
import com.lingyi.base.userfigure.entities.FigureData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class FigureDataImpl implements FigureDataService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Ret addOrUpdateData(FigureData figureData) {
        if (figureData == null) return new Ret(1, "参数不能为空");
        if (null == figureData.getUserBaseId()) return new Ret(2, "无效的用户编码");
        FigureData tmpData = GetFigureData(figureData.getUserBaseId());
        if (null == tmpData) {
            mongoTemplate.save(figureData);
            return new Ret(0, "保存成功");
        } else {
            Query query = new Query(Criteria.where("userBaseId").is(figureData.getUserBaseId()));
            Update update = new Update().set("attributeTags", figureData.getAttributeTags()).set("updateDateTime", figureData.getUpdateDateTime());
            mongoTemplate.updateFirst(query, update, FigureData.class);
            return new Ret(0, "更新成功");
        }
    }

    @Override
    public RetT<FigureData> findByUserBaseId(String userBaseId) {
        if (null == userBaseId) return new RetT<>(1, "无效的用户编码", null);

        FigureData figureData = GetFigureData(userBaseId);
        return new RetT<>(0, "获取数据成功！", figureData);
    }

    private FigureData GetFigureData(String userBaseId) {
        Query query = new Query(Criteria.where("userBaseId").is(userBaseId));
        return mongoTemplate.findOne(query, FigureData.class);
    }
}
