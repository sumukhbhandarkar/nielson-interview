package com.sumukh.controller;

import com.sumukh.entity.Meeting;
import com.sumukh.service.MeetingBookingRequest;
import com.sumukh.service.MeetingBookingResponse;
import com.sumukh.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MeetingController {
    @Autowired
    private SchedulerService schedulerService;

    @PostMapping("/book")
    public ResponseEntity<MeetingBookingResponse> bookMeeting(@RequestBody MeetingBookingRequest request) {
        Meeting meeting = schedulerService.bookMeeeting(
                request.getOrganizerId(), request.getUserIds(), request.getStartTime(), request.getEndTime()
        );
        MeetingBookingResponse response = new MeetingBookingResponse(
                meeting.getId(), "Meeting booked successfully"
        );
        return ResponseEntity.ok(new MeetingBookingResponse(meeting.getId(), "Booked successfully"));
    }
}
