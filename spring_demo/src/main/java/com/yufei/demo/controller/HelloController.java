package com.yufei.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yufei.jiang on 2018/2/27.
 */
@Controller
public class HelloController {
    @RequestMapping(value="/")
    public String home(Model model){
        model.addAttribute("cardPic", "images/sample1.jpg");
        return "resultPage";
    }


    /*@RequestMapping(value="/cardPic")
    public void getCardPic(HttpServletResponse response) throws IOException{
        ClassPathResource classPathResource = new ClassPathResource("/images/sample-1.jpg");
        response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(classPathResource.getFilename()));
        IOUtils.copy(classPathResource.getInputStream(),response.getOutputStream());
    }*/
}

