package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/hw")
    @ResponseBody
    public String index3() {
        return "Hello World!";
    }

    @RequestMapping("/test/{nazwa}")
    @ResponseBody
    public String index2(
            @PathVariable String nazwa,
            @RequestParam Integer age,
            @RequestParam Boolean test
    //http://localhost:8081/test/cos?age=7&test=1
    ) {
        return "hi"+ nazwa + "age" + age +"test" + test;
    }
        @RequestMapping("/")
         public String index() {
            return "index";
        }

}







