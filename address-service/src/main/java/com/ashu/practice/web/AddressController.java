package com.ashu.practice.web;

import com.ashu.practice.dto.AddressDto;
import com.ashu.practice.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/address")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "address", description = "the address API")
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "Get Address by id",
            description = "Get an Address for the given id.",
            tags = {"address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the address",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddressDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping(path = "/{id}")
    public AddressDto view(@PathVariable(name = "id") long id) {
        var address = addressService.view(id);
        log.info("get Address for id={} : {}", id, address);
        return address;
    }
}
