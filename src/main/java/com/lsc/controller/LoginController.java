package com.lsc.controller;

import com.lsc.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @GetMapping("/")
    public String redirectToLogin(){
        LOGGER.info("METHOD: 'redirectToLogin()'");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoingInForm(Model model,
                                  @RequestParam(name="error",  required = false) String error,
                                  @RequestParam(name="logout", required = false) String logout){
        LOGGER.info("METHOD: 'showLoingInForm()' --- PARAMS: ' error = " + error + " - logout = " + logout+ " '");
        model.addAttribute("logout", logout);
        model.addAttribute("error", error);
        LOGGER.info("RETURN TEMPLATE: '" + ViewConstant.LOGIN_FORM + " '");
        return ViewConstant.LOGIN_FORM;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginSuccess(){
        LOGGER.info("METHOD: 'loginSuccess()'");
        LOGGER.info("REDIRECT TO /contacts/listcontacts");
        return "redirect:/contacts/listcontacts";
    }
}
