package edu.miu.cs544.labs.lab3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private String operation;
    private Long duration;

    public ActivityLog(String operation, Long duration) {
        this.date = LocalDate.now();
        this.operation = operation;
        this.duration = duration;
    }
}
