package com.mose.tetris.domain.controller;

import com.mose.tetris.domain.service.test.Chat;
import com.mose.tetris.domain.service.test.Greeting;
import com.mose.tetris.domain.service.test.HellowMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequiredArgsConstructor
public class MainController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HellowMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


    @RequestMapping("index")
    public String aa(){
        return "index";
    }

}
