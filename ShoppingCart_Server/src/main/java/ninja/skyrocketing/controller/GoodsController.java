package ninja.skyrocketing.controller;

import ninja.skyrocketing.common.RespBean;
import ninja.skyrocketing.pojo.Goods;
import ninja.skyrocketing.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	//获取商品列表
	@RequestMapping(value = "/getGoodsList", method = RequestMethod.POST)
	public Map<String, Object> getGoodsListByConditionsPages(@RequestBody Map<String, Object> goodsMap){
		int count = goodsService.getCount(goodsMap);
		List<Goods> goodsList = goodsService.getGoodsListByConditions(goodsMap);
		Map<String, Object> tmpMap = new HashMap<>();
		tmpMap.put("count", count);
		tmpMap.put("list", goodsList);
		return tmpMap;
	}
	
	//添加和修改商品
	@RequestMapping(value = "/saveGoods", method = RequestMethod.POST)
	public RespBean saveGoods(@RequestBody Goods goods){
		//操作结果
		int result = 0;
		
		if(goods.getId() == null){//新增
			goods.setCreatetime(new Date());
			result = goodsService.saveGoods(goods);
		} else {//修改
			result = goodsService.updateGoods(goods);
		}
		if(result > 0){
			return new RespBean("success", "新增成功");
		}
		return new RespBean("error", "新增失败");
	}
	
	//根据ID查询商品信息
	@RequestMapping(value = "/getGoodsById", method = RequestMethod.GET)
	public Goods getGoods(@RequestParam Integer id){
		return goodsService.selectByPrimaryKey(id);
	}
	
	//修改商品状态，0删除，1已上架，2已下架
	@RequestMapping(value = "/updateState", method = RequestMethod.POST)
	public RespBean updateState(@RequestBody Map<String, Object> stateMap){
		int result = 0;
		result = goodsService.updateState(stateMap);
		if(result > 0){
			return new RespBean("success", "操作成功");
		}
		return new RespBean("error", "操作失败");
	}
}
