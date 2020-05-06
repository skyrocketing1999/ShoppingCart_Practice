package ninja.skyrocketing.service.impl;

import ninja.skyrocketing.mapper.CarouselMapper;
import ninja.skyrocketing.pojo.Carousel;
import ninja.skyrocketing.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
	@Autowired
	private CarouselMapper carouselMapper;
	@Override
	public List<Carousel> getCarouselList() {
		return carouselMapper.getCarouselList();
	}
}
