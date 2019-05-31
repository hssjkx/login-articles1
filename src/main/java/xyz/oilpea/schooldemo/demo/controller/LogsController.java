package xyz.oilpea.schooldemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogsController {
    @GetMapping("/logs")
    public String LogPage(){
        return "log/logs";
    }
}
