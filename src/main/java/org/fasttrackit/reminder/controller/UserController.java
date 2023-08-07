package org.fasttrackit.reminder.controller;

import org.fasttrackit.reminder.service.UserService;
import org.fasttrackit.reminder.model.Reminder;
import org.fasttrackit.reminder.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAll() {
        return userService.getAllUsers();
}
    @GetMapping("/{id}")
    public UserModel getById(@PathVariable long id) {
        return userService.getById(id);
    }
    @PostMapping
    public UserModel addNewUser(@RequestBody UserModel user) {
        return userService.add(user);
    }
    @GetMapping("/{id}/reminders")
    public List<Reminder> getReminders(@PathVariable long id, @RequestBody UserModel user) {
        return userService.getUserWithReminders(user.getUsername(), user.getPassword());
    }
}
