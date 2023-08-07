package org.fasttrackit.reminder.controller;

import org.fasttrackit.reminder.service.ReminderService;
import org.fasttrackit.reminder.model.Reminder;
import org.fasttrackit.reminder.model.ReminderDto;
import org.fasttrackit.reminder.model.UserModel;
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
    public Reminder addNewReminder(@RequestBody ReminderDto reminder) {
        return reminderService.add(reminder.getUsername(), reminder.getPassword(), Reminder.builder().name(reminder.getName()).birthday(reminder.getBirthday()).build());
    }
    @PostMapping("/alert")
    public List<Reminder> checkAlerts (@RequestBody ReminderDto reminder){
        return reminderService.checkAlert(reminder);
    }
    @DeleteMapping
    public Reminder deleteById( @RequestBody ReminderDto reminder) {
        return reminderService.delete(reminder);
    }

    @PostMapping
    public List<Reminder> getAllByUser(@RequestBody UserModel userModel){
        return reminderService.getAllByUser(userModel);
    }
}


