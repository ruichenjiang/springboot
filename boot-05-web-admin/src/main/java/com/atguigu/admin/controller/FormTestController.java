package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormTestController {


    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "from/from_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param userName
     * @param file
     * @param photos
     * @return
     */
    @PostMapping
    public String upload(@RequestParam("email")String email,
                         @RequestParam("userName")String userName,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息:email={},userName={},headerImg={},photos={}",email,userName,headerImg,photos.length);
        if(!headerImg.isEmpty()){

            String originalFileName = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\cache\\" + originalFileName));
        }
        if(photos.length > 0){
            for(MultipartFile multipartFile:photos){
                if(!multipartFile.isEmpty()){
                    String originalFileName = headerImg.getOriginalFilename();
                    headerImg.transferTo(new File("E:\\cache\\" + originalFileName));
                }
            }
        }

        return "main";
    }
}
