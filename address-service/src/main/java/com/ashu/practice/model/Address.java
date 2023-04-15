package com.ashu.practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address implements Serializable {

    private static final String ADDRESS_ID_SEQUENCE = "ADDRESS_ID_SEQUENCE";

    @Serial
    private static final long serialVersionUID = 631483777200626772L;

    @Id
    @SequenceGenerator(name = ADDRESS_ID_SEQUENCE, sequenceName = ADDRESS_ID_SEQUENCE, allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = ADDRESS_ID_SEQUENCE)
    private long id;

    @Column(length = 10, nullable = false)
    private AddressType type;

    @Column(length = 50)
    private String locality;

    @Column(length = 50, nullable = false)
    private String city;

    private int zip;


}
