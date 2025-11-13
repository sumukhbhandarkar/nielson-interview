package com.sumukh.repository;

import com.sumukh.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r from room r WHERE r.id NOT IN (SELECT m.room.id FROM meeting m WHERE m.startTime < :end AND m.endTime > :start")
    List<Room> findAvailableRoom(@Param("start") LocalDateTime start,
                                 @Param("end") LocalDateTime end);
}
