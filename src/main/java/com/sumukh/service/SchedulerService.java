package com.sumukh.service;

import com.sumukh.entity.Meeting;
import com.sumukh.entity.Room;
import com.sumukh.entity.User;
import com.sumukh.repository.MeetingRepository;
import com.sumukh.repository.RoomRepository;
import com.sumukh.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SchedulerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MeetingRepository meetingRepository;

    @Transactional
    public Meeting bookMeeeting(Long organizerId, List<Long> userIds, LocalDateTime start, LocalDateTime end) {
        List<User> users = userRepository.findAllById(userIds);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, u -> u));
        Room availableRoom = findAvailableRoom(start, end);

        List<Meeting> conflicts = meetingRepository.findConflictingMeetings(userIds, start, end);
        if (!conflicts.isEmpty()) {
            throw new RuntimeException("Some user not available");
        }

        Meeting meeting = new Meeting();
        meeting.setOrganizer(userMap.get(organizerId));
        meeting.setUsers(users.stream().map(userMap::get).collect(Collectors.toList()));
        meeting.setRoom(availableRoom);
        meeting.setStartTime(start);
        meeting.setEndTime(end);
        return meetingRepository.save(meeting);
    }

    public Room findAvailableRoom(LocalDateTime start, LocalDateTime end) {
        List<Room> availableRooms = roomRepository.findAvailableRoom(start, end);
        if (availableRooms.isEmpty()) {
            throw new RuntimeException("No available room in said time slot");
        }
        return availableRooms.get(0);
    }
}

//    private boolean areUsersAvailable(List<User> users, LocalDateTime start, LocalDateTime end) {
//        //
//        return true;
//    }
//
//    private Room findAvailableRoom(int requiredCapacity, LocalDateTime start, LocalDateTime end) {
//        //
//        return null;
//    }
//
//    private void sendNotification(List<User> users, String message) {
//        //
//    }

