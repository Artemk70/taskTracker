package com.taskTracker.model;

import com.taskTracker.model.enums.StatusOfTheProject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
@Getter
@Setter
@ToString
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "completion_date")
    private LocalDateTime completionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('NotStarted','Active','Completed')")
    private StatusOfTheProject statusOfTheProject;

    @Column(name = "priority")
    private int priority;
}
