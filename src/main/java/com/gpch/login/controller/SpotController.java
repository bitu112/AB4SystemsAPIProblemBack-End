package com.gpch.login.controller;

import com.gpch.login.model.Spot;
import com.gpch.login.model.User;
import com.gpch.login.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SpotController {

    @Autowired
    private SpotService spotService;

    @RequestMapping(value="/spots", method = RequestMethod.GET)
    public ModelAndView spots(){
        ModelAndView modelAndView = new ModelAndView();
        List<Spot> spots = spotService.findAll();
        modelAndView.addObject("spots",spots);
        modelAndView.addObject("adminMessage","List of Spots");
        modelAndView.setViewName("/spots");
        return modelAndView;
    }
    @RequestMapping(value="/spots/countries", method = RequestMethod.GET)
    public ModelAndView spotsCountry(){
        ModelAndView modelAndView = new ModelAndView();
        List<Spot> spots = spotService.findAll();
        modelAndView.addObject("spots",spots);
        modelAndView.addObject("adminMessage","List of Spots");
        modelAndView.setViewName("/countries");
        return modelAndView;
    }
    @RequestMapping(value="/spots/{id}", method = RequestMethod.GET)
    public ModelAndView spotsById(@PathVariable(value="id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        Spot spot = spotService.findSpotById(id);
        modelAndView.addObject("spots",spot);
        modelAndView.setViewName("/id");
        return modelAndView;
    }
    @RequestMapping(value="/add_spot", method = RequestMethod.GET)
    public ModelAndView addSpot(){
        ModelAndView modelAndView = new ModelAndView();
        Spot spot = new Spot();
        modelAndView.addObject("spot",spot);
        modelAndView.setViewName("add_spot");
        return modelAndView;
    }

    @RequestMapping(value = "/add_spot", method = RequestMethod.POST)
    public ModelAndView createNewSpot(@Valid Spot spot, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Spot spotExists = spotService.findSpotByName(spot.getName());
        if (spotExists != null) {
            bindingResult
                    .rejectValue("name", "error.spot",
                            "There is already a spot registered with the name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("add_spot");
        } else {
            spotService.saveSpot(spot);
            modelAndView.addObject("successMessage", "Spot has been created successfully");
            modelAndView.addObject("spot", new Spot());
            modelAndView.setViewName("add_spot");
        }
        return modelAndView;
    }


}
