package com.userservice.controller;

import com.userservice.config.JwtService;
import com.userservice.dto.AuthRequestDTO;
import com.userservice.dto.JwtResponseDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public JwtResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        System.out.println("ss");
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()) {
            System.out.println("--------------");
            return JwtResponseDTO.builder()
                    .accessToken(this.jwtService.GenerateToken(authRequestDTO.getUsername())).build();
        } else {
            System.out.println("sssssssserrrr");
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }

}
