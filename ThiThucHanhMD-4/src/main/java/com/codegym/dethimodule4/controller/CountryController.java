package com.codegym.dethimodule4.controller;

import com.codegym.dethimodule4.model.City;
import com.codegym.dethimodule4.model.Country;
import com.codegym.dethimodule4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryService countries;

    @GetMapping("/add")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("/city/country-add");
        return modelAndView;
    }


    @PostMapping("/add")
    public ModelAndView addNewCity(@Valid @ModelAttribute Country country, BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/city/country-add");
            return modelAndView;
        }
        countries.save(country);
        modelAndView = new ModelAndView("/city/index");
        modelAndView.addObject("countries", countries.findAll());
        return modelAndView;
    }
}
