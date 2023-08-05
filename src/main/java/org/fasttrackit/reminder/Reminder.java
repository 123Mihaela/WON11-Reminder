package org.fasttrackit.reminder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;

@RequiredArgsConstructor
@Getter
@Builder
@Entity

public class Reminder {
    @Id
    @GeneratedValue
    private final Long id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private final DateModel date;
    @Column
    private final String name;
    @JsonIgnore
    @ManyToOne
    private final UserModel user;
}
