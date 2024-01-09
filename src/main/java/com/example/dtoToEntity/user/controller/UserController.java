package com.example.dtoToEntity.user.controller;

import com.example.dtoToEntity.classRoom.dto.AllClassRoomByUserId;
import com.example.dtoToEntity.classRoom.service.ClassRoomService;
import com.example.dtoToEntity.user.dto.CreateDto;
import com.example.dtoToEntity.user.repo.UserRepo;
import com.example.dtoToEntity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final ClassRoomService classRoomService;
    private final UserRepo userRepo;
    private final UserService userService;

    @GetMapping("/user/{userId}")
    public AllClassRoomByUserId findAllClassRoomByUserId(@PathVariable Long userId){
        return classRoomService.findAllClassRoomByUserId(userId);
    }

    @PostMapping("/user")
    public ResponseEntity<CreateDto> saveUser(){
        CreateDto createDto = userService.create();
        return ResponseEntity.ok(createDto);
    }
}
