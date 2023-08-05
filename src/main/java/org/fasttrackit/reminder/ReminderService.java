package org.fasttrackit.reminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Reminder add (Reminder reminder) {
        reminders.add(reminder);
        return reminder;
    }

    public Reminder getById(long id) {
        return reminders.stream().filter(reminder -> reminder.getId()==id ).findAny().orElse(null);
    }

    public List<String> getAllByUser(UserModel userModel) {
        return userService.getUserWithReminders(userModel.getUsername(),userModel.getPassword());

    }
}
