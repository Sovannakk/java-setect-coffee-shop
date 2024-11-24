package com.kshrd.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_booked")
@ToString
public class Booked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate date;
    @DateTimeFormat(pattern = "h:mm a")
    private LocalTime time;
    private Long personId;
}
