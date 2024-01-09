package com.example.dtoToEntity.classRoom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllClassRoomByUserId {
    Long userId;
    String name;
    List<ClassRoomDto> classRoomDtos;
}
