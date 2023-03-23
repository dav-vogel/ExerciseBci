package com.exercise.bci.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercise.bci.dto.response.ResponseDTO;
import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.dto.user.UserDTO;
import com.exercise.bci.exception.TechnicalBciException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api( tags = { "Users Authentication" } )
@RequestMapping( path = "/users" )
public interface UsersController {

    @PostMapping( path = "/login" )
    @ApiResponses( value = @ApiResponse( code = 200, message = "OK", response = UserDTO.class ) )
    ResponseEntity<ResponseDTO<ResponseUserDTO>> login( RequestUserDTO user );

    @PostMapping( path = "/sign-up" )
    @ApiResponses({ 
    	@ApiResponse( code = 200, message = "OK", response = UserDTO.class ),
        @ApiResponse(code = 406, message = "Usuario existente", response = TechnicalBciException.class),
    })
    ResponseEntity<ResponseDTO<ResponseUserDTO>> signUp( RequestUserDTO user ) throws TechnicalBciException;

    @GetMapping( path = "/report" )
    @ApiResponses( value = @ApiResponse( code = 200, message = "OK", response = List.class ) )
    ResponseEntity<ResponseDTO<List<UserDTO>>> report();

}
