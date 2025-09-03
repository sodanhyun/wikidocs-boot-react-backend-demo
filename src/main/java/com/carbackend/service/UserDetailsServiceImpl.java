package com.carbackend.service;

import com.carbackend.domain.AppUser;
import com.carbackend.domain.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 실제 해당 username(ID)을 가지는 유저가 DB에 존재하는지 확인
        // + 해당 유저정보를 UserDetails 타입으로 반환하는 메서드
        Optional<AppUser> user = appUserRepository.findByUsername(username);

        UserDetails userDetails = null;
        if(user.isPresent()) {
            AppUser appUser = user.get();
            userDetails = User.withUsername(username)
                    .password(appUser.getPassword())
                    .roles(appUser.getRole())
                    .build();
        }else {
            throw new UsernameNotFoundException("User not found.");
        }
        return userDetails;
    }
}
