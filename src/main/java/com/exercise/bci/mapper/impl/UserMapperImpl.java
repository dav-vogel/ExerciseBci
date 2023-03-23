package com.exercise.bci.mapper.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.exercise.bci.dto.user.PhoneDTO;
import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.entity.PhoneEntity;
import com.exercise.bci.entity.UserEntity;
import com.exercise.bci.mapper.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public ResponseUserDTO userEntityToUserDTO(UserEntity user) {
		return this.userEntityToUserDTO(user, null);
	}

	@Override
	public ResponseUserDTO userEntityToUserDTO(UserEntity user, String token) {
		ResponseUserDTO resp = new ResponseUserDTO();
		BeanUtils.copyProperties(user, resp);
		resp.setToken(token);
		if(Optional.ofNullable(user.getPhones()).isPresent())
			resp.setPhones(user.getPhones().stream()
					.map(ph -> phoneEntityToPhoneDTO(ph) )
					.collect(Collectors.toSet()));
		
		return resp;
	}

	@Override
	public UserEntity userDTOToUserEntity(RequestUserDTO user) {
		UserEntity usEnt = new UserEntity();
		BeanUtils.copyProperties(user, usEnt);

		if(Optional.ofNullable(user.getPhones()).isPresent())
			usEnt.setPhones(user.getPhones().stream()
					.map(ph -> phoneDTOToPhoneEntity(ph) )
					.collect(Collectors.toSet()));
		
		return usEnt;
	}

    PhoneDTO phoneEntityToPhoneDTO( PhoneEntity phone ) {
    	PhoneDTO dto = new PhoneDTO();
    	BeanUtils.copyProperties(phone, dto);
    	return dto;
    }

    PhoneEntity phoneDTOToPhoneEntity( PhoneDTO phone ) {
    	PhoneEntity phEnt = new PhoneEntity();
    	BeanUtils.copyProperties(phone, phEnt);
    	return phEnt;
    }

}
