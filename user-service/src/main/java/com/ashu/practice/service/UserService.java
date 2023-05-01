package com.ashu.practice.service;

import com.ashu.practice.dto.UserDto;
import com.ashu.practice.dto.UserPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserPage viewAll(Pageable pageable);
    UserDto view(Long id);

    void update(Long id, UserDto userDto);

    void delete(Long id);
}
