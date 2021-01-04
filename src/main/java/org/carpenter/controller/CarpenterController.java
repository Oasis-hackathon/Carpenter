package org.carpenter.controller;

import org.carpenter.domain.common.RoleName;
import org.carpenter.domain.user.CarpenterService;
import org.carpenter.domain.user.dto.JoinDto;
import org.carpenter.domain.user.dto.UpdateDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarpenterController {

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

    @GetMapping("/user/mypage")
    public ModelAndView mypage(ModelAndView modelAndView, Principal principal) {
        String email = principal.getName();
        UpdateDto dto = carpenterService.getCarpenter(email);
        modelAndView.addObject("updateDto",dto);
        modelAndView.setViewName("user/mypage");
        return modelAndView;
    }

    @PostMapping ("/user/update")
    public ModelAndView update(ModelAndView modelAndView, UpdateDto dto) {
        UpdateDto updatedDto = carpenterService.update(dto);
        modelAndView.addObject("updateDto", updatedDto);
        modelAndView.setViewName("redirect:/user/mypage");
        return modelAndView;
    }

    @PostMapping("/user/delete")
    public String delete(UpdateDto dto) {
        carpenterService.delete(dto);
        return "redirect:/login";
    }
}
