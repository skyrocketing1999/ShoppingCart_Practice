package ninja.skyrocketing.controller;

import ninja.skyrocketing.pojo.Carousel;
import ninja.skyrocketing.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
	@Autowired
	private CarouselService carouselService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Carousel> getCarouselList(){
		return carouselService.getCarouselList();
	}
}
