package com.dingxiang.serviceRepositories;

import com.google.common.base.Strings;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    Client client;

    @Override
    public void geoSearch() {

        int pageIndex = 0;
        int pageSize = 100;
        String fieldName = "location";

        double lat = 39.909;
        double lon = 116.397;
        int instance = 1000;

        SearchRequestBuilder srb = client.prepareSearch("user").setTypes("user");
        srb.setFrom(pageIndex).setSize(pageSize);
        GeoDistanceQueryBuilder location1 = QueryBuilders.geoDistanceQuery(fieldName).point(lat, lon).distance(instance, DistanceUnit.MILES);
        srb.setPostFilter(location1);

        /*//根据性别进行帅选
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (param.getSex() != SexTypeEnum.All) {
            QueryBuilder queryBuilder = QueryBuilders.matchQuery("sex", param.getSex().getValue());
            boolQueryBuilder.must(queryBuilder);
        }
        //根据坐标更新时间进行帅选
        if (param.getGeo().getAfterDay() != 0) {
            RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("locationLastDate");

            rangeQueryBuilder.gte(System.currentTimeMillis() - param.getGeo().getAfterDay() * SECONDS_PER_DAY);
            boolQueryBuilder.filter(rangeQueryBuilder);
        }
        srb.setQuery(boolQueryBuilder);*/

        // 获取距离多少公里 这个才是获取点与点之间的距离的
        GeoDistanceSortBuilder sort = SortBuilders.geoDistanceSort(fieldName, lat, lon);
        sort.unit(DistanceUnit.MILES);
        sort.order(SortOrder.ASC);
        sort.point(lat, lon);
        srb.addSort(sort);


        SearchResponse searchResponse = srb.execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHists = hits.getHits();

        for (SearchHit hit : searchHists) {

            String userId = (String) hit.getSource().get("id");
            if (Strings.isNullOrEmpty(userId)) userId = "";

            String nickName = (String) hit.getSource().get("nickName");
            if (Strings.isNullOrEmpty(nickName)) nickName = "";

            List<Double> location = (List<Double>) hit.getSource().get("location");


            BigDecimal geoDis = new BigDecimal((Double) hit.getSortValues()[0]);
            Map<String, Object> hitMap = hit.getSource();
            hitMap.put("geoDistance", geoDis.setScale(0, BigDecimal.ROUND_HALF_DOWN));

            Object tmpDis = hit.getSource().get("geoDistance");
            String geoDistance = "0";
            if (tmpDis instanceof BigDecimal)
                geoDistance = String.valueOf(tmpDis);
        }
    }
}
