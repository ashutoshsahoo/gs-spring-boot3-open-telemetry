package com.ashu.practice.dto;


import lombok.Data;

@Data
public class AddressDto {

    private long id;
    private String type;
    private String locality;
    private String city;
    private int zip;

}
