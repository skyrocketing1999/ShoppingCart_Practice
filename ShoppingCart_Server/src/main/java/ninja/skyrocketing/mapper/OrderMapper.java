package ninja.skyrocketing.mapper;

import ninja.skyrocketing.pojo.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    //根据用户id查询订单列表
    List<Order> getOrderList(Integer userId);
    
    List<Order> getOrderUnionList(Integer orderId);
}