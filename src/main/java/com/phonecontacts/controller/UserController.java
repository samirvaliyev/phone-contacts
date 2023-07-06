package com.phonecontacts.controller;

import com.phonecontacts.dto.UserRequestDto;
import com.phonecontacts.dto.UserResponseDto;
import com.phonecontacts.service.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //register
    @PostMapping("/sign-up")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody UserRequestDto requestDto) {
        log.trace("Create user body {}", requestDto);
        return new ResponseEntity<>(userService.signUp(requestDto), HttpStatus.CREATED);
    }
}
