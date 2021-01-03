package org.carpenter.user;

import org.carpenter.common.RoleName;
import org.carpenter.user.dto.UserJoinDto;
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
    private UserService userService;

    @GetMapping("/join")
    public ModelAndView join(ModelAndView modelAndView) {
        List<RoleName> roleNameList = Arrays.asList(RoleName.values());

        modelAndView.addObject("roleNameList", roleNameList);
        modelAndView.addObject("userJoinDto", new UserJoinDto());
        modelAndView.setViewName("user/join");
        return modelAndView;
    }

    @PostMapping("/signup")
    public String signUp(UserJoinDto joinDto) {
        userService.save(joinDto);
        return "redirect:/user/login";
    }
}
