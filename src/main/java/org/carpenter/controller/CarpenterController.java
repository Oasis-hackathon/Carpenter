package org.carpenter.controller;

import org.carpenter.domain.common.RoleName;
import org.carpenter.domain.user.service.CarpenterService;
import org.carpenter.domain.user.dto.JoinDto;
import org.carpenter.domain.user.dto.UpdateDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/user")
@Controller
public class CarpenterController {

    @Resource
    private CarpenterService carpenterService;

    @GetMapping("/mypage")
    public ModelAndView mypage(ModelAndView modelAndView) {
        modelAndView.setViewName("user/mypage");
        return modelAndView;
    }

    @PostMapping ("/update")
    public ModelAndView update(ModelAndView modelAndView, UpdateDto dto) {
        UpdateDto updatedDto = carpenterService.update(dto);
        modelAndView.addObject("updateDto", updatedDto);
        modelAndView.setViewName("redirect:/user/mypage");
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(UpdateDto dto) {
        carpenterService.delete(dto);
        return "redirect:/login";
    }

    @GetMapping("/my-goal-list")
    public ModelAndView getMyList(ModelAndView modelAndView) {
        modelAndView.setViewName("/goal/list");
        return modelAndView;
    }

    @GetMapping("/edit-profile")
    public ModelAndView getEditProfilePage(ModelAndView modelAndView, Principal principal) {
        String email = principal.getName();
        UpdateDto dto = carpenterService.getCarpenter(email);
        modelAndView.addObject("updateDto",dto);
        modelAndView.setViewName("/user/edit-profile");
        return modelAndView;
    }
}
