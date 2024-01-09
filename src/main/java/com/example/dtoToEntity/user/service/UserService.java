package com.example.dtoToEntity.user.service;

import com.example.dtoToEntity.user.dto.CreateDto;
import com.example.dtoToEntity.user.entity.User;
import com.example.dtoToEntity.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public CreateDto create(){
        User u = User.builder()
                .name("test")
                .build();
        userRepo.save(u);
        return CreateDto.builder()
                .name(u.getName())
                .build();
    }
}
