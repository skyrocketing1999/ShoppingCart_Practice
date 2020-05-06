package ninja.skyrocketing.mapper;

import ninja.skyrocketing.pojo.OrderGoodsDetail;

public interface OrderGoodsDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoodsDetail record);

    int insertSelective(OrderGoodsDetail record);

    OrderGoodsDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderGoodsDetail record);

    int updateByPrimaryKey(OrderGoodsDetail record);
}