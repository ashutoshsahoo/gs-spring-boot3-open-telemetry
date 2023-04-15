package com.ashu.practice.dto;


import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private int age;
    private AddressDto address;

}
