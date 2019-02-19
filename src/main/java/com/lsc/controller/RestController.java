package com.lsc.controller;

import com.lsc.model.ContactModel;
import com.lsc.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @Autowired
    @Qualifier ("contactService")
    private ContactServiceImpl contactService;

    @GetMapping("/checkrest")
    public ResponseEntity<String> checkRest(){
        return new ResponseEntity <String> ( "Ok!", HttpStatus.OK );
    }

    @GetMapping("/contactrest")
    public ResponseEntity< ContactModel > contactRest(){
        return new ResponseEntity <ContactModel> ( contactService.findContactById ( 7 ), HttpStatus.OK );
    }
}
