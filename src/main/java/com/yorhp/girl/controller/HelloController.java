package com.yorhp.girl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HelloController {

    /*@Value("${cupSize}")
    private String cupSize;*/

    //@RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    @GetMapping(value = "/hi")
    public String say(@RequestParam(value = "word", required = false, defaultValue = "哈哈") String word) {
        return "word：" + word;
    }


    @PutMapping(value = "/hi")
    public String say() {
        return "xxx";
    }



}
