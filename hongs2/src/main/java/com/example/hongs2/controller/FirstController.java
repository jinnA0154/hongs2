package com.example.hongs2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    // 띄우는(Popup)하는 컨트롤러
    @GetMapping("/hi")
    public String niceToMeetYou (Model model) {
        model.addAttribute("username", "경진님");
        return "greetings";
    }
}
