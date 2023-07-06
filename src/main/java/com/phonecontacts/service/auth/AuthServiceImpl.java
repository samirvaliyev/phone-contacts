package com.phonecontacts.service.auth;

import com.phonecontacts.dto.login.LoginRequestDto;
import com.phonecontacts.dto.login.LoginResponseDto;
import com.phonecontacts.entity.User;
import com.phonecontacts.exception.WrongPasswordException;
import com.phonecontacts.repository.UserRepository;
import com.phonecontacts.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public LoginResponseDto singIn(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail());
        checkLoginPassword(loginRequestDto, user);
        final String token = jwtService.generateAccessToken(user);
        return LoginResponseDto.builder()
                .accessToken(token)
                .build();
    }

    private void checkLoginPassword(LoginRequestDto loginRequestDto, User user) {
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }
    }
}
