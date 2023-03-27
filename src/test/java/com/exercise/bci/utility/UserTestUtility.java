package com.exercise.bci.utility;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.exercise.bci.dto.user.PhoneDTO;
import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.entity.PhoneEntity;
import com.exercise.bci.entity.UserEntity;

public class UserTestUtility {

	public static RequestUserDTO generateRequestUserDTO() {
		RequestUserDTO req = new RequestUserDTO();
		req.setEmail("email@gmail.com");
		req.setName("name");
		req.setPassword("Holamundo23");
		req.setPhones(getPhonesDto());
		req.setToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYXYyX3ZvZ2VsQDM4Z21haWwuY29tIiwibm9tYnJlIjoiRGF2aWQgVm9nZWwiLCJlbWFpbCI6ImRhdjJfdm9nZWxAMzhnbWFpbC5jb20iLCJpYXQiOjE2Nzk1ODMzMzN9.719pjJIf37Ux4hf3vOdMom1Sawz1UrCOcBdHS-Xuwn8");
		
		return req;
	}

	public static RequestUserDTO generateRequestUserDTOFaildEmail() {
		RequestUserDTO req = new RequestUserDTO();
		req.setEmail("email@gmail");
		req.setName("name");
		req.setPassword("holaMundo23");
		req.setPhones(getPhonesDto());
		req.setToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYXYyX3ZvZ2VsQDM4Z21haWwuY29tIiwibm9tYnJlIjoiRGF2aWQgVm9nZWwiLCJlbWFpbCI6ImRhdjJfdm9nZWxAMzhnbWFpbC5jb20iLCJpYXQiOjE2Nzk1ODMzMzN9.719pjJIf37Ux4hf3vOdMom1Sawz1UrCOcBdHS-Xuwn8");
		
		return req;
	}

	public static RequestUserDTO generateRequestUserDTOFaildPassword() {
		RequestUserDTO req = new RequestUserDTO();
		req.setEmail("email@gmail.com");
		req.setName("name");
		req.setPassword("holaMundo");
		req.setPhones(getPhonesDto());
		req.setToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYXYyX3ZvZ2VsQDM4Z21haWwuY29tIiwibm9tYnJlIjoiRGF2aWQgVm9nZWwiLCJlbWFpbCI6ImRhdjJfdm9nZWxAMzhnbWFpbC5jb20iLCJpYXQiOjE2Nzk1ODMzMzN9.719pjJIf37Ux4hf3vOdMom1Sawz1UrCOcBdHS-Xuwn8");
		
		return req;
	}
	
	public static ResponseUserDTO generateResponseUserDTO() {
		ResponseUserDTO response = new ResponseUserDTO();
		response.setEmail("email@gmail.com");
		response.setIsActive(Boolean.TRUE);
		response.setName("name");
		response.setPhones(getPhonesDto());
		response.setToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYXYyX3ZvZ2VsQDM4Z21haWwuY29tIiwibm9tYnJlIjoiRGF2aWQgVm9nZWwiLCJlbWFpbCI6ImRhdjJfdm9nZWxAMzhnbWFpbC5jb20iLCJpYXQiOjE2Nzk1ODMzMzN9.719pjJIf37Ux4hf3vOdMom1Sawz1UrCOcBdHS-Xuwn8");
		return response;
	}
	
	public static UserEntity userDTOToUserEntity( RequestUserDTO user ) {
		UserEntity entity = new UserEntity();
		entity.setCreated(LocalDateTime.now());
		entity.setEmail("email@gmail.com");
		entity.setIsActive(Boolean.TRUE);
		entity.setLastLogin(LocalDateTime.now());
		entity.setName("name");
		entity.setPassword("Holamundo23");
		entity.setPhones(getPhonesEntity());
		return entity;
	}

	private static Set<PhoneDTO> getPhonesDto() {
		PhoneDTO ph = new PhoneDTO();
		ph.setCityCode(12);
		ph.setCountryCode("cod");
		ph.setNumber(192837L);
		Set<PhoneDTO> set = new HashSet<>();
		set.add(ph);
		return set;
	}
	
	private static Set<PhoneEntity> getPhonesEntity() {
		PhoneEntity ph = new PhoneEntity();
		ph.setCityCode(12);
		ph.setCountryCode("cod");
		ph.setNumber(192837L);
		Set<PhoneEntity> set = new HashSet<>();
		set.add(ph);
		return set;
	}
}
