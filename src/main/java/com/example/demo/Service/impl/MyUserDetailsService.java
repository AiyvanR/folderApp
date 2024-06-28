package com.example.demo.Service.impl;

import com.example.demo.Config.userDetails;
import com.example.demo.Entity.MyUser;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user= repository.findByName(username);
        return user.map(userDetails::new).orElseThrow(()-> new UsernameNotFoundException(username + "not found"));
    }
}
