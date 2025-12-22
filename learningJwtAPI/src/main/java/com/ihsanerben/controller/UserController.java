package com.ihsanerben.controller;

import com.ihsanerben.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/favorites")
    public Set<?> getFavorites(Authentication authentication) {
        return userService.getFavoriteMovies(authentication.getName());
    }
}
