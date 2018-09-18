package mybatis.mapper;

import mybatis.po.Orders;
import mybatis.po.OrdersCustom;
import mybatis.po.User;

import java.util.List;

public interface UserMapperOrders {

    //��ѯ������������ѯ�û���Ϣ
    List<OrdersCustom> findOrdersUser() throws Exception;


    //��ѯ������������ѯ�û���Ϣ,ʹ��resultMap
    List<OrdersCustom> findOrdersUserResultMap() throws Exception;

    //��ѯ�����������û�����������ϸ
    List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    //��ѯ�û�������Ʒ��Ϣ
    List<User> findUserAndItemsResultMap() throws Exception;

    //��ѯ�����������û���ѯ���û���ѯ�õ����ӳټ���
    List<Orders> findOrdersUserLazyLoading() throws Exception;
}
