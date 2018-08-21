package com.yjh.study.basicSystem.controller;

import com.yjh.study.basicSystem.config.DataConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    DataConfig dataConfig;

    @GetMapping("")
    public String hello(Model model) {
        model.addAttribute("param", "world");
        return "hello";
    }

    @GetMapping("/system")
    public String showSystemInfo() {
        return dataConfig.getSystemName() + "<br>"
                + dataConfig.getSystemUUID() + "<br>"
                + dataConfig.getSystemDescription();
    }

}
