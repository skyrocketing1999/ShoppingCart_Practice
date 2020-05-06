package ninja.skyrocketing.service.impl;

import ninja.skyrocketing.mapper.GoodsTypeMapper;
import ninja.skyrocketing.pojo.GoodsType;
import ninja.skyrocketing.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
	@Override
	public List<GoodsType> getGoodsTypeList() {
		return goodsTypeMapper.getGoodsTypeList();
	}
}
