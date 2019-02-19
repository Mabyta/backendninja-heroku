package com.lsc.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestScrypt {
    public static void main(String[] args){
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("user"));
    }
}
