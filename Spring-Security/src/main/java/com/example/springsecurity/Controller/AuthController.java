package com.example.springsecurity.Controller;


import com.example.springsecurity.Api.ApiResponse;
import com.example.springsecurity.Model.MyUser;
import com.example.springsecurity.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid MyUser user) {
        authService.Register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("user registered successfully"));
    }
}
