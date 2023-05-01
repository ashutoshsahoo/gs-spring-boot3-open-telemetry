package com.ashu.practice.dto;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serial;
import java.util.List;

public class UserPage extends PageImpl<UserDto> {
    @Serial
    private static final long serialVersionUID = 7531901227357839808L;

    public UserPage(List<UserDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}