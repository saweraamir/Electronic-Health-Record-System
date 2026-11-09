package com.medcrm.model;

import java.time.LocalDateTime;

class Reminder{
    //Data Members
    private final String reminderID;
    private final User user;
    private String message;
    private LocalDateTime reminderTime;

    //Constructor
    Reminder(String reminderId, User user, String message, LocalDateTime reminderTime, String reminderID) {
        this.reminderID = reminderID;
        this.user = user;
        this.message = message;
        this.reminderTime = reminderTime;
    }

    //Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    //Getters
    public String getReminderID() {
        return reminderID;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    //Methods
    public void sendReminder() {
        System.out.println("Reminder to " + user.getName() + ": " + message + " at " + reminderTime);
    }

    public void updateReminder(LocalDateTime newTime, String newMessage) {
        this.reminderTime = newTime;
        this.message = newMessage;
        System.out.println("Reminder updated for " + user.getName() + " to: " + message + " at " + reminderTime);
    }

}
