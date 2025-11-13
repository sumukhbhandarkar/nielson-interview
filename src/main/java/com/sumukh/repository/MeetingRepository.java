package com.sumukh.repository;

import com.sumukh.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query("SELECT m FROM meeting m JOIN m.users u WHERE u.id IN :userIds AND m.startTime <:end AND m.endTime > :start")
    List<Meeting> findConflictingMeetings(@Param("userIds") List<Long> userIds,
                                          @Param("start")LocalDateTime start,
                                          @Param("end") LocalDateTime end);

}
