package com.example.demo.common.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonAction {

    @GetMapping("/name")
    public String getCommon(@RequestParam("name")String name){
        return "{\"id\":1}";

    }

}
