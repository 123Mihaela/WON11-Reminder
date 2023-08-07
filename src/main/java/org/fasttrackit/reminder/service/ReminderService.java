package org.fasttrackit.reminder.service;

import org.fasttrackit.reminder.model.Reminder;
import org.fasttrackit.reminder.model.ReminderDto;
import org.fasttrackit.reminder.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReminderService {
    private List<Reminder> reminders = new ArrayList<>();
    @Autowired
    private UserService userService;
    public ReminderService() {
    }
    public List<Reminder> getAllReminders() {
        return reminders;
    }
    public Reminder add (String username, String password, Reminder reminder) {
        UserModel user= userService.getUser(username , password);
        user.getReminders().add(reminder);
        userService.save(user);
        return reminder;
    }

    public Reminder getById(long id) {
        return reminders.stream().filter(reminder -> reminder.getId()==id ).findAny().orElse(null);
    }

    public List<Reminder> getAllByUser(UserModel userModel) {
        return userService.getUserWithReminders(userModel.getUsername(),userModel.getPassword());

    }

    public Reminder delete(ReminderDto reminderDto) {
        UserModel user = userService.getUser(reminderDto.getUsername(), reminderDto.getPassword());
       Reminder reminder = user.getReminders().stream().filter(r-> r.getName().equals(reminderDto.getName())).findAny().orElseThrow();
       user.removeReminder(reminder);
       userService.save(user);
        return reminder;
    }

    public List<Reminder> checkAlert(ReminderDto reminderDto) {
        UserModel user = userService.getUser(reminderDto.getUsername(), reminderDto.getPassword());
        return user.getReminders().stream().filter(reminder -> reminder.getBirthday().getDayOfMonth()== LocalDate.now().getDayOfMonth() &&
                reminder.getBirthday().getMonthValue()==LocalDate.now().getMonthValue()).toList();
    }
}
