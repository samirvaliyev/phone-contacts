package com.phonecontacts.service.user;

import com.phonecontacts.dto.UserRequestDto;
import com.phonecontacts.dto.UserResponseDto;

public interface UserService {

    UserResponseDto signUp(UserRequestDto requestDto);
}
