package com.phonecontacts.service.user;

import com.phonecontacts.dto.user.UserRequestDto;
import com.phonecontacts.dto.user.UserResponseDto;

public interface UserService {

    UserResponseDto signUp(UserRequestDto requestDto);
}
