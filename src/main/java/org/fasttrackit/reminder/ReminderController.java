package org.fasttrackit.reminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("reminders")
public class ReminderController {
    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public List<Reminder> getAll() {
        return reminderService.getAllReminders();
    }
    @GetMapping("/{id}")
    public Reminder getById(@PathVariable long id) {
        return reminderService.getById(id);
    }
    @PostMapping("/new")
    public Reminder addNewReminder(@RequestBody Reminder reminder) {
        return reminderService.add(reminder);
    }

    @PostMapping
    public List<String> getAllByUser(@RequestBody UserModel userModel){
        return reminderService.getAllByUser(userModel);
    }
}


