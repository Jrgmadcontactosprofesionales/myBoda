package com.jorgealvarez.myboda.controller;

import com.jorgealvarez.myboda.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeddingListController {
    @Autowired
    private AttendantRepository attendantRepository;

    @GetMapping({"/lista-de-bodas"})
    public ModelAndView getAttendants() {
        ModelAndView modelAndView = new ModelAndView("/wedding-list");
        return modelAndView;
    }
}
