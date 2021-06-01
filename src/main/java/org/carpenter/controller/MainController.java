package org.carpenter.controller;

import org.carpenter.domain.common.RoleName;
import org.carpenter.domain.user.dto.JoinDto;
import org.carpenter.domain.user.service.CarpenterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @Resource
    private CarpenterService carpenterService;

    @GetMapping("/join")
    public ModelAndView join(ModelAndView modelAndView) {
        List<RoleName> roleNameList = Arrays.asList(RoleName.values());

        modelAndView.addObject("roleNameList", roleNameList);
        modelAndView.setViewName("user/join");
        return modelAndView;
    }

    @PostMapping("/signup")
    public String signUp(JoinDto joinDto) {
        carpenterService.save(joinDto);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @RequestMapping
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/calendar")
    public String calendar() {
        return "calendar";
    }
}
