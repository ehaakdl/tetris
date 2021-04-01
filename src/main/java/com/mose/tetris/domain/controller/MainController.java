package com.mose.tetris.domain.controller;

import com.mose.tetris.domain.common.eUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @RequestMapping(value={"", "index"})
    public String getIndex() {
        return eUrl.index.toString();
    }
}
