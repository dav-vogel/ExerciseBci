package com.exercise.bci.service;

import java.util.List;

import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.dto.user.UserDTO;
import com.exercise.bci.exception.TechnicalBciException;

public interface UsersService {

    ResponseUserDTO login( RequestUserDTO userDTO ) throws TechnicalBciException;

    ResponseUserDTO addUser( RequestUserDTO userDTO ) throws TechnicalBciException;

    List<UserDTO> getAllUsers();

}
