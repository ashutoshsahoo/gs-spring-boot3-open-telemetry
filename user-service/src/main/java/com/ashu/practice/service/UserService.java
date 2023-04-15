package com.ashu.practice.service;

import com.ashu.practice.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> viewAll(Pageable pageable);
    UserDto view(Long id);

    void update(Long id, UserDto userDto);

    void delete(Long id);
}
