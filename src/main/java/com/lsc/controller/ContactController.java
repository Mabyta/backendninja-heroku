package com.lsc.controller;

import com.lsc.constant.ViewConstant;
import com.lsc.model.ContactModel;
import com.lsc.service.impl.ContactServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    @Qualifier ("contactService")
    private ContactServiceImpl contactService;

    private static final Log LOGGER = LogFactory.getLog ( ContactController.class );

    @GetMapping ("/listcontacts")
    public String listContacts ( Model model ,
                                 @RequestParam (name = "add", required = false) String add ) {
        LOGGER.info ( "METHOD: 'listContacts()' --- RETURN TEMPLATE: '" + ViewConstant.CONTACTOS + " ' --- PARAMS: ' add = " + add + " '" );
        User user = ( User ) SecurityContextHolder.getContext ( ).getAuthentication ( ).getPrincipal ( );
        model.addAttribute ( "add" , add );
        model.addAttribute ( "username" , user.getUsername ( ) );
        model.addAttribute ( "contacts" , contactService.listAllContacts ( ) );
        return ViewConstant.CONTACTOS;
    }

    @PreAuthorize ("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping ("/contactform")
    public String getFormContact ( Model model ) {
        LOGGER.info ( "METHOD: 'getFormContact()'" );
        model.addAttribute ( "contactModel" , new ContactModel ( ) );
        LOGGER.info ( "RETURN TEMPLATE: '" + ViewConstant.CONTACT_FORM + " '" );
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping ("/addcontact")
    public String addcontact ( @Valid @ModelAttribute ("contactModel") ContactModel contactModel ,
                               BindingResult bindingResult ) {
        LOGGER.info ( "METHOD: 'addcontact()' --- PARAMS: ' contactModel = " + contactModel.toString ( ) + " '" );
        if ( bindingResult.hasErrors ( ) ) {
            LOGGER.info ( "RETURN TEMPLATE: '" + ViewConstant.CONTACTOS + " '" );
            return ViewConstant.CONTACTOS;
        } else {
            LOGGER.info ( "REDIRECT TO /contacts/listcontacts" );
            if ( null != contactService.addContact ( contactModel ) ) {
                return "redirect:/contacts/listcontacts?add=1";
            } else {
                return "redirect:/contacts/listcontacts?add=0";
            }
        }
    }

    @PostMapping ("/remove")
    public String removeContact ( @ModelAttribute (name = "id") long id ) {
        LOGGER.info ( "METHOD: 'removeContact()' --- PARAMS: ' id = " + id + " '" );
        ContactModel contactModel = contactService.findContactById ( id );
        contactService.remove ( contactModel );
        return "redirect:/contacts/listcontacts";
    }

    @PostMapping ("/update")
    public String updateFormContact ( Model model , @ModelAttribute (name = "id") long id ) {
        LOGGER.info ( "METHOD: 'updateFormContact()' --- PARAMS: ' id = " + id + " '" );
        ContactModel contactModel = contactService.findContactById ( id );
        model.addAttribute ( "contactModel" , contactModel );
        return ViewConstant.CONTACT_FORM;
    }
}
