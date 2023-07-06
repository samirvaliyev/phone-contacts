package com.phonecontacts.security.user;

import com.phonecontacts.entity.User;
import com.phonecontacts.exception.UserNotFoundException;
import com.phonecontacts.repository.UserRepository;
import com.phonecontacts.security.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDto loadUserByUsername(final String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user.getEmail().isEmpty()) {
            throw new UserNotFoundException();
        }
        return convertUser(user);
    }

    private UserDto convertUser(final User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                List.of()
        );
    }
}
