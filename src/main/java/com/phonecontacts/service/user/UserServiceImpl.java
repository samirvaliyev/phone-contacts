package com.phonecontacts.service.user;

import com.phonecontacts.dto.user.UserRequestDto;
import com.phonecontacts.dto.user.UserResponseDto;
import com.phonecontacts.entity.User;
import com.phonecontacts.entity.UserRole;
import com.phonecontacts.exception.UserAlreadyExistsException;
import com.phonecontacts.repository.UserRepository;
import com.phonecontacts.security.role.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto signUp(UserRequestDto requestDto) {
        alreadyTakenEmail(requestDto.getEmail());
        UserRole roleBuilder = UserRole.builder()
                .name(RoleEnum.USER.name())
                .build();
        User userBuilder = User.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(roleBuilder)
                .build();
        userRepository.save(userBuilder);
        return modelMapper.map(userBuilder, UserResponseDto.class);
    }

    private void alreadyTakenEmail(final String email) {
        final boolean exists = userRepository
                .existsByEmail(email);
        if (exists) {
            throw new UserAlreadyExistsException();
        }
    }
}
