package com.lsc.service.impl;

import com.lsc.converter.UserConverter;
import com.lsc.entity.UserRole;
import com.lsc.model.UserCredential;
import com.lsc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;

    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        com.lsc.entity.User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildAutorities(user.getUserRole());
        return bulldUser(user, authorities);
    }

    public void addUser(UserCredential userCredential){
        userRepository.save ( userConverter.ModelToEntity ( userCredential ) );
    }

    private User bulldUser( com.lsc.entity.User user, List<GrantedAuthority> authorities){
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(),true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAutorities( Set<UserRole> userRoles ){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for(UserRole userRole : userRoles){
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }
}
