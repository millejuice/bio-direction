package com.example.dtoToEntity.classRoom.service;

import com.example.dtoToEntity.classRoom.dto.AllClassRoomByUserId;
import com.example.dtoToEntity.classRoom.dto.ClassRoomDto;
import com.example.dtoToEntity.classRoom.entity.ClassRoom;
import com.example.dtoToEntity.classRoom.repo.ClassRoomRepo;
import com.example.dtoToEntity.user.entity.User;
import com.example.dtoToEntity.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassRoomService {
    private final UserRepo userRepo;
    private final ClassRoomRepo classRoomRepo;

    public ClassRoomDto converToClassRoomDto(ClassRoom classRoom){
        return ClassRoomDto.builder()
                .classRoomId(classRoom.getClassRoomId())
                .userId(classRoom.getUser().getId())
                .build();
    }

    public AllClassRoomByUserId findAllClassRoomByUserId(Long userId){
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()){
            User u = user.get();
            List<ClassRoomDto> classRoom = u.getClassRoom().stream()
                    .map(this::converToClassRoomDto)
                    .toList();
            return AllClassRoomByUserId.builder()
                    .userId(u.getId())
                    .name(u.getName())
                    .classRoomDtos(classRoom)
                    .build();
        }
        else {
            throw new IllegalArgumentException("해당 유저가 없습니다.");
        }
    }
    public void saveClassRoom(Long userId){
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()){
            User u = user.get();
            ClassRoom classRoom = ClassRoom.builder()
                    .user(u)
                    .build();
            classRoomRepo.save(classRoom);
        }
        else {
            throw new IllegalArgumentException("해당 유저가 없습니다.");
        }
    }
}
