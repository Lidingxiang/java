package mybatis.mapper;

import mybatis.po.Orders;
import mybatis.po.OrdersCustom;
import mybatis.po.User;

import java.util.List;

public interface UserMapperOrders {

    //查询订单，关联查询用户信息
    List<OrdersCustom> findOrdersUser() throws Exception;


    //查询订单，关联查询用户信息,使用resultMap
    List<OrdersCustom> findOrdersUserResultMap() throws Exception;

    //查询订单（关联用户）及订单明细
    List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    //查询用户购买商品信息
    List<User> findUserAndItemsResultMap() throws Exception;

    //查询订单，关联用户查询，用户查询用的是延迟加载
    List<Orders> findOrdersUserLazyLoading() throws Exception;
}
