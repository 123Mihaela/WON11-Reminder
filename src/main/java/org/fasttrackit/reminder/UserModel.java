package org.fasttrackit.reminder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@Getter
@Builder
@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private final Long id;
    @Column
    private final String username;
    @Column
    private final String password;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private final List<Reminder> reminders;
}

