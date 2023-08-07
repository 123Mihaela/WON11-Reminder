package org.fasttrackit.reminder.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReminderDto {
    private String name;
    private LocalDate birthday;
    private String username;
    private String password;
}
