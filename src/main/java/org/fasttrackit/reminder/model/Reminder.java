package org.fasttrackit.reminder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Reminder {
    @Id
    @GeneratedValue
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column
    private LocalDate birthday;
    @Column
    private String name;

}
