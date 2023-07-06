package com.phonecontacts.controller;

import com.phonecontacts.dto.login.LoginRequestDto;
import com.phonecontacts.dto.login.LoginResponseDto;
import com.phonecontacts.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> singIn(@RequestBody LoginRequestDto requestDto) {
        log.trace("Login user success body {}", requestDto);
        return new ResponseEntity<>(authService.singIn(requestDto), HttpStatus.OK);
    }
}
