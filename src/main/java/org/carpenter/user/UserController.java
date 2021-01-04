package org.carpenter.user;

import org.carpenter.common.RoleName;
import org.carpenter.user.dto.CarpenterJoinDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

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
    public String signUp(CarpenterJoinDto joinDto) {
        carpenterService.save(joinDto);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }
}
