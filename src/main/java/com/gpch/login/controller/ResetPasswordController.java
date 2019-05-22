package com.gpch.login.controller;

import com.gpch.login.model.User;
import com.gpch.login.service.MailService;
import com.gpch.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ResetPasswordController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService notificationService;

    @RequestMapping(value="/forgot_password", method = RequestMethod.GET)
    public ModelAndView forgot(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/forgot_password");
        return modelAndView;
    }

    @RequestMapping(value = "/forgot_password",method = RequestMethod.POST)
    public ModelAndView forgot(@RequestParam("email") String email) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(email);
        if (userExists == null) {
          modelAndView.setViewName("/login");
        }
         else {
            try {
                notificationService.sendEmail(email);
            } catch (MailException mailException) {
                System.out.println(mailException);
            }
            userExists.setResetToken("TOKEN");
            userService.saveUser(userExists);
            modelAndView.setViewName("Token");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/confirm_token",method = RequestMethod.POST)
    public ModelAndView verifyToken(@RequestParam("token") String token){
        ModelAndView modelAndView = new ModelAndView();
        User userToken = userService.findUserByResetToken(token);
        if (userToken.getResetToken().equals(token)){
            modelAndView.setViewName("/reset_password");
        }else
        { modelAndView.setViewName("/login");}
        return modelAndView;
    }
    @RequestMapping(value="/reset_password", method = RequestMethod.GET)
    public ModelAndView reset(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/reset_password");
        return modelAndView;
    }
    @RequestMapping(value = "/reset_password",method = RequestMethod.POST)
    public ModelAndView resetPassword(@RequestParam("password") String password,@RequestParam("email") String email,@RequestParam("confirmPassword") String confirmPassword){
        ModelAndView modelAndView = new ModelAndView();
        if (password.equals(confirmPassword)){
            User user = userService.findUserByEmail(email);
            user.setPassword(password);
            userService.saveUser(user);
            modelAndView.setViewName("redirect:/login");
        }else
        {
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }
}
