package ninja.skyrocketing.mapper;

import ninja.skyrocketing.pojo.Carousel;

import java.util.List;

public interface CarouselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
    
    //获取轮播图列表
    List<Carousel> getCarouselList();
}