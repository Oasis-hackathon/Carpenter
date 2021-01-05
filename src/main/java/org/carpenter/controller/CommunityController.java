package org.carpenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/community")
@Controller
public class CommunityController {

    @GetMapping
    public ModelAndView community(ModelAndView modelAndView) {
        modelAndView.setViewName("community/community");
        return modelAndView;
    }
}
