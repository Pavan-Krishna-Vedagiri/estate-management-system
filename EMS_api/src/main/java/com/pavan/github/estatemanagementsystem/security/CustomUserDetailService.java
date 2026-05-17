package com.pavan.github.estatemanagementsystem.security;

import com.pavan.github.estatemanagementsystem.entities.UserAuth;
import com.pavan.github.estatemanagementsystem.repositories.UserAuthRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserAuthRepo userAuthRepo;

    public CustomUserDetailService(UserAuthRepo userAuthRepo) {
        this.userAuthRepo = userAuthRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userAuthRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return User.withUsername(userAuth.getUsername())
                .password(userAuth.getPassword())
                .roles("USER").build();

    }
}
