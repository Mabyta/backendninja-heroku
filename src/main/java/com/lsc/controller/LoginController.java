package com.lsc.controller;

import com.lsc.constant.ViewConstant;
import com.lsc.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @GetMapping({"/login","/"})
    public String showLoingInForm(Model model,
                                  @RequestParam(name="error",  required = false) String error,
                                  @RequestParam(name="logout", required = false) String logout){
        LOGGER.info("METHOD: 'showLoingInForm()' --- PARAMS: ' error = " + error + " - logout = " + logout + " '");
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

    @GetMapping("/register")
    public String showFormRegister(Model model){
        model.addAttribute ( "user", new UserCredential());
        return ViewConstant.REGISTER_FORM;
    }

    @PostMapping("/adduser")
    public String addUser( @Valid @ModelAttribute(name = "user") UserCredential userCredential, BindingResult bindingResult ){
        if(!bindingResult.hasErrors()){

        }
        return "redirect:/login";
    }
}
