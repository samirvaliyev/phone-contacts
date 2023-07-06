package com.phonecontacts.service.user;

import com.phonecontacts.dto.UserRequestDto;
import com.phonecontacts.dto.UserResponseDto;
import com.phonecontacts.entity.User;
import com.phonecontacts.entity.UserRole;
import com.phonecontacts.repository.UserRepository;
import com.phonecontacts.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserResponseDto signUp(UserRequestDto requestDto) {
        //exists user
        User userBuilder = User.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(new UserRole())//refactore this line
                .build();
        userRepository.save(userBuilder);
        final String token = jwtService
                .generateAccessToken(userBuilder);
        return UserResponseDto.builder()
                .accessToken(token)
                .build();
    }
}
