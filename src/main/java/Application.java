
//Problem: Design a Meeting Scheduler
//We need to design the backend service for a meeting scheduler. The goal is to build a system that can book a meeting room for a
// group of users, ensuring that both the room and all participants are available.
//
//Requirements:
//Multiple Rooms: The system has many rooms. A user doesn't want to pick a specific room; they just want any available room that fits
// their needs.
//Room Features: Rooms now have properties, like capacity. The bookMeeting request will now specify the number of attendees.
//New Booking Logic: The bookMeeting method should now:
//Take a list of userIds, a startTime, endTime, and numberOfAttendees.
//First, check if all users are available.
//If they are, find the first available room that has enough capacity and is free at that time.
//Book the meeting in that room.
//Notifications: After a successful booking, the system should send a notification to all attendees.


public class Application {
    public static void main(String[] args) {
        
    }
}
