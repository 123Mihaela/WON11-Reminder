package org.fasttrackit.reminder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@Entity
public class DateModel {
    @Id
    @GeneratedValue
    private final Long id;
    @Column
    private final int dayValue;
    @Column
    private final int monthValue;
    @Column
    private final int yearValue;
    @JsonIgnore
    @OneToOne(mappedBy = "date")
    private final Reminder reminder;
}
