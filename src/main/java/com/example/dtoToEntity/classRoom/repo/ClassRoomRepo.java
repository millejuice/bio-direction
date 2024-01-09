package com.example.dtoToEntity.classRoom.repo;

import com.example.dtoToEntity.classRoom.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClassRoom, Long> {
}
