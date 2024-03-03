package com.demo.model1;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "courses")


public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseId")
    private int courseId;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "coursePrice")
    private int coursePrice;
}
