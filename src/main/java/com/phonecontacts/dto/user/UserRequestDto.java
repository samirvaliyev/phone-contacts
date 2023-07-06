package com.phonecontacts.dto.user;

import com.phonecontacts.util.ValidEmail;
import com.phonecontacts.util.ValidPassword;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String name;

    @ValidEmail
    String email;

    String address;

    @ValidPassword
    String password;
}
