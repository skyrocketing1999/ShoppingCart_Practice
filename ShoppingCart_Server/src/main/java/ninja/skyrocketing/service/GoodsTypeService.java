package ninja.skyrocketing.service;

import ninja.skyrocketing.pojo.GoodsType;
import org.springframework.stereotype.Service;
import java.util.List;

public interface GoodsTypeService {
	List<GoodsType> getGoodsTypeList();
}
