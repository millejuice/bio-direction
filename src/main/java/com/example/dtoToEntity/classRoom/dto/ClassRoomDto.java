package com.example.dtoToEntity.classRoom.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassRoomDto {
    private Long classRoomId;
    private Long userId;
}
