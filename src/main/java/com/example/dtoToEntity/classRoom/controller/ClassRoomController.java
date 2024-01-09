package com.example.dtoToEntity.classRoom.controller;

import com.example.dtoToEntity.classRoom.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClassRoomController {
    private final ClassRoomService classRoomService;
    @PostMapping("/{userId}/classRoom")
    public void createClassRoom(@PathVariable Long userId){
        classRoomService.saveClassRoom(userId);
    }
}
