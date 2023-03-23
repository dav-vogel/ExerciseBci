package com.exercise.bci.controller.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.bci.controller.UsersController;
import com.exercise.bci.dto.response.ErrorDTO;
import com.exercise.bci.dto.response.ResponseDTO;
import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.dto.user.UserDTO;
import com.exercise.bci.exception.TechnicalBciException;
import com.exercise.bci.service.UsersService;


@RestController
public class UsersControllerImpl implements UsersController {

	@Autowired
    private UsersService usersService;

    @Override
    public ResponseEntity<ResponseDTO<ResponseUserDTO>> login( @Valid @RequestBody RequestUserDTO user ) {
        ResponseDTO<ResponseUserDTO> response = new ResponseDTO<>();
        try {
	        response.setData( usersService.login( user ) );
	        return new ResponseEntity<>( response, HttpStatus.OK );
        } catch (Exception e) {
        	response.setError(createErrorDTO(e));
        	return new ResponseEntity<>( response, HttpStatus.resolve(Integer.valueOf(response.getError().getCode())) );
		}
    }

    @Override
    public ResponseEntity<ResponseDTO<ResponseUserDTO>> signUp( @Valid @RequestBody RequestUserDTO user ) throws TechnicalBciException {
        ResponseDTO<ResponseUserDTO> response = new ResponseDTO<>();
        try {
        	response.setData( usersService.addUser( user ) );
            return new ResponseEntity<>( response, HttpStatus.CREATED );
        } catch (Exception e) {
        	response.setError(createErrorDTO(e));
        	return new ResponseEntity<>( response, HttpStatus.resolve(Integer.valueOf(response.getError().getCode())) );
		}
    }

    @Override
    public ResponseEntity<ResponseDTO<List<UserDTO>>> report() {
        ResponseDTO<List<UserDTO>> response = new ResponseDTO<>();
        response.setData( usersService.getAllUsers() );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }
    
    private ErrorDTO createErrorDTO(Exception e) {
    	ErrorDTO error = new ErrorDTO();
    	error.setTimestamp(LocalDateTime.now());
    	if(e instanceof TechnicalBciException) {
    		TechnicalBciException ex = (TechnicalBciException) e;
        	error.setCode(ex.getError().getCodigo());
        	error.setDetail(ex.getError().getDetalle());
    	} else {
    		error.setCode("500");
    		error.setDetail(e.getMessage());
    	}
    	return error;
    }

}
