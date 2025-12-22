package com.ihsanerben.service;

import com.ihsanerben.entity.User;
import com.ihsanerben.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Set<?> getFavoriteMovies(String email) {
        User user = getUserByEmail(email);
        return user.getFavoriteMovies();
    }
}
