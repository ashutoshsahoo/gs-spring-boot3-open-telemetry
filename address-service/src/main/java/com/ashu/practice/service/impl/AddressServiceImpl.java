package com.ashu.practice.service.impl;

import com.ashu.practice.dto.AddressDto;
import com.ashu.practice.model.Address;
import com.ashu.practice.repository.AddressRepository;
import com.ashu.practice.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public AddressDto view(long id) {
        return mapModelToDto(addressRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address with " + id + " not found")));
    }


    private AddressDto mapModelToDto(Address address) {
        var addressDto = new AddressDto();
        BeanUtils.copyProperties(address, addressDto,"type");
        addressDto.setType(address.getType().name());
        return addressDto;
    }
}
