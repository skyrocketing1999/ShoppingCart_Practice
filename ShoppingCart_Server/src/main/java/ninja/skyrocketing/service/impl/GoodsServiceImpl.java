package ninja.skyrocketing.service.impl;

import ninja.skyrocketing.mapper.GoodsMapper;
import ninja.skyrocketing.pojo.Goods;
import ninja.skyrocketing.pojo.User;
import ninja.skyrocketing.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public List<Goods> getGoodsListByConditions(Map<String, Object> goodsMap) {
		return goodsMapper.getGoodsListByConditions(goodsMap);
	}
	@Override
	public int getCount(Map<String, Object> goodsMap) {
		return goodsMapper.getCount(goodsMap);
	}
	
	@Override
	public int saveGoods(Goods goods) {
		return goodsMapper.insertSelective(goods);
	}
	
	@Override
	public int updateGoods(Goods goods) {
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}
	
	@Override
	public Goods selectByPrimaryKey(Integer id) {
		return goodsMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public int updateState(Map<String, Object> stateMap) {
		return goodsMapper.updateState(stateMap);
	}
}
