package com.sumukh.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingBookingRequest {
    private Long organizerId;
    private List<Long> userIds;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
