package com.ashu.practice.web;

import com.ashu.practice.dto.AddressDto;
import com.ashu.practice.service.AddressService;
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
public class UserController {

    private final AddressService addressService;

    @GetMapping(path = "/{id}")
    public AddressDto view(@PathVariable(name = "id") long id) {
        var address = addressService.view(id);
        log.info("get Address for id={} : {}",id, address);
        return address;
    }
}
