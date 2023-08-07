package org.fasttrackit.reminder.service;

import org.fasttrackit.reminder.repository.UserRepository;
import org.fasttrackit.reminder.model.Reminder;
import org.fasttrackit.reminder.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private List<UserModel> users = new ArrayList<>();

    private UserRepository usersRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.usersRepository = userRepository;
        List<Reminder> reminders = new ArrayList<>();
        reminders.addAll(List.of(Reminder.builder().name("Mihaela").birthday(LocalDate.of(1990, 11, 1)).build(),
                Reminder.builder().name("Elisei").birthday(LocalDate.of(1991, 8, 31)).build(),
                Reminder.builder().name("Ioana").birthday(LocalDate.of(1988, 2, 13 )).build(),
                Reminder.builder().name("Ionut").birthday(LocalDate.of(1995, 4, 13)).build()));
        UserModel userModel = UserModel.builder()
                .username("Mihaela")
                .password("password")
                .reminders(reminders)
                .build();
        usersRepository.save(userModel);

    }

    public List<UserModel> getAllUsers() {
        return users;
    }
    public UserModel add (UserModel user) {
        users.add(user);
        return user;
    }

    public UserModel getById(long id) {
        return users.stream().filter(user -> user.getId()==id ).findAny().orElse(null);
    }

    public List<Reminder> getUserWithReminders(String username, String password) {
        return usersRepository.findAll().stream().filter(userModel -> userModel.getUsername().equals(username) && userModel.getPassword().equals(password) )
                .flatMap(userModel -> userModel.getReminders().stream()).toList();
    }

    public UserModel getUser(String username, String password) {
        return usersRepository.findAll().stream().filter(userModel -> userModel.getUsername().equals(username) && userModel.getPassword().equals(password) ).findAny().orElseThrow();
    }

    public void save(UserModel user) {
        usersRepository.save(user);
    }
}
