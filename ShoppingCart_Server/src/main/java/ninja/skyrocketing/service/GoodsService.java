package ninja.skyrocketing.service;

import ninja.skyrocketing.pojo.Goods;
import ninja.skyrocketing.pojo.User;

import java.util.List;
import java.util.Map;

public interface GoodsService {
	//多条件分页查询列表
	List<Goods> getGoodsListByConditions(Map<String, Object> goodsMap);
	
	//获得总记录数
	int getCount(Map<String, Object> goodsMap);
	
	//添加商品save
	int saveGoods(Goods goods);
	
	//修改商品信息
	int updateGoods(Goods goods);
	
	//根据ID查询商品信息
	Goods selectByPrimaryKey(Integer id);
	
	//修改商品状态，0删除，1已上架，2已下架
	int updateState(Map<String, Object> stateMap);
}
