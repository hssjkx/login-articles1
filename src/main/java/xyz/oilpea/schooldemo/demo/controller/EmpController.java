package xyz.oilpea.schooldemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {
    @GetMapping("/emps")
    public String EmpPage(){
        return "emp/emps";
    }
}
