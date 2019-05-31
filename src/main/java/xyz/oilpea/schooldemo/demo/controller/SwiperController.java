package xyz.oilpea.schooldemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwiperController {
    @GetMapping("/swiper")
    public String toAddPage(){
        return "swiper/swiper";
    }

}
