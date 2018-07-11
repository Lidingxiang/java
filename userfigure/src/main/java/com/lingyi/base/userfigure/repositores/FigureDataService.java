package com.lingyi.base.userfigure.repositores;

import com.lingyi.base.userfigure.DoMain.Ret;
import com.lingyi.base.userfigure.DoMain.RetT;
import com.lingyi.base.userfigure.entities.FigureData;

/**
 * 用户画像数据存储
 */
public interface FigureDataService {

    Ret addOrUpdateData(FigureData figureData);

    RetT<FigureData> findByUserBaseId(String userBaseId);
}
