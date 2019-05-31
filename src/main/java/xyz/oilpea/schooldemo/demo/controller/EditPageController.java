package xyz.oilpea.schooldemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditPageController {

    @GetMapping("/editpage")
    public String EditPagePage(){
        return "editPage/editpage";
    }
}
