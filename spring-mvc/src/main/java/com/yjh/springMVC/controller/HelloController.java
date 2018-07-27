package com.yjh.springMVC.controller;

import com.yjh.springMVC.entity.UserEntity;
import com.yjh.springMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
//    @ResponseBody
    public String hello(HttpServletRequest request) {
        request.getSession().setAttribute("uid", "uid");
        return "hello";
    }

    @PostMapping("/upload")
//    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        //上传文件的名称
        String fileName = file.getOriginalFilename();
        //获取一个路径
        String path = request.getSession().getServletContext().getRealPath("upload");

        path = "/home/yjh/";

        File targetFile = new File(path, fileName);

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        try {
            //将上传的文件写入目标文件
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (!file.isEmpty()) {
            System.out.println(file.getSize());
            return "hello";
        }

        return "fail";
    }

    @GetMapping("/json")
    @ResponseBody
    public UserEntity json() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("yjh");
        userEntity.setPassword("123");
        return userEntity;
    }

    @PostMapping("/user")
    @ResponseBody
    public String user(UserEntity userEntity) {

        return userEntity.getUsername() + " " + userEntity.getPassword();
    }

    @GetMapping("/user")
    @ResponseBody
    public UserEntity getUser() {
        return userService.getUser();
    }
}
