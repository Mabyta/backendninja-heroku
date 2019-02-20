package com.lsc.converter;

import com.lsc.entity.User;
import com.lsc.model.UserCredential;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter {

    public User ModelToEntity( UserCredential userCredential ){
        User user = new User();
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        user.setEnabled ( true );
        user.setUsername ( userCredential.getUsername () );
        user.setPassword ( pe.encode ( userCredential.getPassword () ) );
        return user;
    }
}
