package com.ashu.practice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Setter
@Getter
@ToString
public class AddressDto {

    @Schema(example = "1000", description = "identifier")
    private long id;
    @Schema(type = "string",allowableValues = "OFFICE,PRESENT,PERMANENT", defaultValue = "PRESENT", description = "Address Type")
    private String type;
    @Schema(example = "locality" ,description = "Locality")
    private String locality;
    @Schema(example = "New Delhi", description = "City")
    private String city;
    @Schema(example = "110110", description = "Zip code")
    private int zip;

}
