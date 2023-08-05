package org.fasttrackit.reminder;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private List<UserModel> users = new ArrayList<>();

    public UserService() {
        UserModel userModel = UserModel.builder()
                .username("username")
                .password("password")
                .reminders(List.of(Reminder.builder().name("Mihaela").build(),
                        Reminder.builder().name("Elisei").build(),
                        Reminder.builder().name("Ioana").build(),
                        Reminder.builder().name("Ionut").build()))
                .build();
        users.add(userModel);

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

    public List<String> getUserWithReminders(String username, String password) {
        return users.stream().filter(userModel -> userModel.getUsername().equals(username) && userModel.getPassword().equals(password) )
                .flatMap(userModel -> userModel.getReminders().stream() )
                .map(Reminder::getName)
                .toList();
    }
}
