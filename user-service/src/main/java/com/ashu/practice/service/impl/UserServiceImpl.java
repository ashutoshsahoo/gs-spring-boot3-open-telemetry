package com.ashu.practice.service.impl;

import com.ashu.practice.UserRepository;
import com.ashu.practice.dto.AddressDto;
import com.ashu.practice.dto.UserDto;
import com.ashu.practice.model.User;
import com.ashu.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<UserDto> viewAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(this::mapModelToDto);
    }

    @Override
    public UserDto view(Long id) {
        return userRepository.findById(id)
                .map(this::mapModelToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with " + id + " not found"));
    }

    @Override
    public void update(Long id, UserDto userDto) {

    }

    @Override
    public void delete(Long id) {

    }

    UserDto mapModelToDto(User user) {
        var userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        var addressDto = getAddressById(user.getAddressId());
        userDto.setAddress(addressDto);
        return userDto;
    }

    private AddressDto getAddressById(long id) {
        var restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(URI.create("http://localhost:8085/api/v1/address/" + id), AddressDto.class);
        log.info("Response from Address service for id={} is {}", id, response);
        return response;
    }

}
