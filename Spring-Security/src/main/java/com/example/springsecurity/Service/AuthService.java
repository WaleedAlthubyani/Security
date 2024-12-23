package com.example.springsecurity.Service;


import com.example.springsecurity.Model.MyUser;
import com.example.springsecurity.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public void Register(MyUser user) {
        user.setRole("USER");
        String hashPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);

        authRepository.save(user);
    }
}
