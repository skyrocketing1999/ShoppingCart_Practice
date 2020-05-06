package ninja.skyrocketing.mapper;

import com.fasterxml.jackson.databind.util.ObjectBuffer;
import ninja.skyrocketing.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    //多条件分页查询列表
    List<Goods> getGoodsListByConditions(Map<String, Object> goodsMap);
    
    //获得总记录数
    int getCount(Map<String, Object> goodsMap);
    
    //修改商品状态，0删除，1已上架，2已下架
    int updateState(Map<String, Object> stateMap);
}