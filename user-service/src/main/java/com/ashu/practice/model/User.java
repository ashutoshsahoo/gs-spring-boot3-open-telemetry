package com.ashu.practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Table(name = "USERS")
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {


    private static final String USER_ID_SEQUENCE = "USER_ID_SEQUENCE";

    @Serial
    private static final long serialVersionUID = 6919546963077586857L;

    @Id
    @SequenceGenerator(name = USER_ID_SEQUENCE, sequenceName = USER_ID_SEQUENCE, allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = USER_ID_SEQUENCE)
    private long id;

    @Column(length = 30, nullable = false)
    private String name;

    private int age;

    private long addressId;

}
