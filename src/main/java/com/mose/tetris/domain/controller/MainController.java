package com.mose.tetris.domain.controller;

import com.mose.tetris.domain.common.eUrl;
import com.mose.tetris.domain.repository.member.MemberInfoRepository;
import com.mose.tetris.domain.repository.member.TokenInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping(value={"", "index"})
    public String getIndex() {
        return eUrl.index.toString();
    }
}
