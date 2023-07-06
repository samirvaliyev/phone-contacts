package com.phonecontacts.service.auth;

import com.phonecontacts.dto.login.LoginRequestDto;
import com.phonecontacts.dto.login.LoginResponseDto;

public interface AuthService {

    LoginResponseDto singIn(LoginRequestDto loginRequestDto);
}
