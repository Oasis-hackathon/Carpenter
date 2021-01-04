package org.carpenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/goals")
@Controller
public class GoalController {

    @GetMapping
    public ModelAndView goals(ModelAndView modelAndView) {
        modelAndView.setViewName("goal/list");
        return modelAndView;
    }

    @GetMapping("/newgoal")
    public String newGoal() {
        return "goal/form";
    }

    @PostMapping("/newgoal")
    public ModelAndView saveNewGoal(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/goals/tree");
        return modelAndView;
    }

    @GetMapping("/tree")
    public ModelAndView goalTree(ModelAndView modelAndView) {
        return modelAndView;
    }
}
