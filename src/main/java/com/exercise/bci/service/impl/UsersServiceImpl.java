package com.exercise.bci.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.bci.constant.RegularExpresionConst;
import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.dto.user.UserDTO;
import com.exercise.bci.entity.UserEntity;
import com.exercise.bci.enums.Error;
import com.exercise.bci.exception.TechnicalBciException;
import com.exercise.bci.mapper.UserMapper;
import com.exercise.bci.repository.UserRepository;
import com.exercise.bci.security.TokenUtils;
import com.exercise.bci.service.UsersService;


@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserMapper userMaper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseUserDTO login( RequestUserDTO userDTO ) throws TechnicalBciException {

    	String email = TokenUtils.getAuthentication(userDTO.getToken());
        UserEntity userEntity = Optional.ofNullable(
                	this.userRepository.findByEmail(email)
        		).orElseThrow(() -> new TechnicalBciException(Error.NOT_FOUND) );
        
        userEntity.setLastLogin( new Date() );
        String token = TokenUtils.createToken(userDTO.getName(), userDTO.getEmail());

        return UserMapper.INSTANCE.userEntityToUserDTO(
                this.userRepository.saveAndFlush( userEntity ), token);
    }

    @Override
    public ResponseUserDTO addUser( RequestUserDTO userDTO ) throws TechnicalBciException {
    	
    	UserEntity entityDB = this.userRepository.findByEmail(userDTO.getEmail());
    	if (Optional.ofNullable(entityDB).isPresent())
    		throw new TechnicalBciException(Error.USER_EXISTS);
    	
    	validateEmail(userDTO.getEmail());
    	validatePassord(userDTO.getPassword());
    	
        UserEntity userEntity = userMaper.userDTOToUserEntity( userDTO );
        userEntity.setIsActive( true );
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        String token = TokenUtils.createToken(userDTO.getName(), userDTO.getEmail());

        return userMaper.userEntityToUserDTO(this.userRepository.saveAndFlush( userEntity ), token);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(user -> UserMapper.INSTANCE.userEntityToUserDTO(user))
                .collect( Collectors.toList() );
    }
    
    private void validatePassord(String password) throws TechnicalBciException {
    	if(!password.matches(RegularExpresionConst.REGULAR_EXPRESION_PASSWORD))
    		throw new TechnicalBciException(Error.PASSWORD_NOT_VALID);
    }
    
    private void validateEmail(String email) throws TechnicalBciException {
    	if(!email.matches(RegularExpresionConst.REGULAR_EXPRESION_EMAIL))
    		throw new TechnicalBciException(Error.EMAIL_NOT_VALID);
    }

}
