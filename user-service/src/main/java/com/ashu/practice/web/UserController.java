package com.ashu.practice.web;

import com.ashu.practice.dto.UserDto;
import com.ashu.practice.dto.UserPage;
import com.ashu.practice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "users", description = "the user API")
public class UserController {

    private final UserService userService;


    @Operation(summary = "View all users",
            description = "View all the users.",
            tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A single page of Users-20 records",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserPage.class) )}),
            @ApiResponse(responseCode = "404", description = "No users found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping
    public UserPage getUsers() {
        var response = userService.viewAll(Pageable.ofSize(20));
        log.info("get users: {}", response);
        return response;
    }


    @Operation(summary = "Get User by id",
            description = "Get an User for the given id.",
            tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema)}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "user not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    @GetMapping(path = "/{id}")
    public UserDto viewUsers(@PathVariable(name = "id") Long id) {
        log.info("Request received to view user for id: {}", id);
        var response = userService.view(id);
        log.info("view user: {}", response);
        return response;
    }
}
