package com.exercise.bci.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.exception.TechnicalBciException;
import com.exercise.bci.mapper.UserMapper;
import com.exercise.bci.repository.UserRepository;
import com.exercise.bci.utility.UserTestUtility;

@RunWith(SpringRunner.class)
public class UsersServiceImplTest {

	private UserRepository userRepository = mock(UserRepository.class);
	
	private UserMapper userMaper = mock(UserMapper.class);
	
	private PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
	
	private UsersServiceImpl usersServiceImpl = new UsersServiceImpl(userRepository, userMaper, passwordEncoder);
	
	@Test
	void addUserTest() throws TechnicalBciException {
		RequestUserDTO reqDTO = UserTestUtility.generateRequestUserDTO();
		when(this.userMaper.userDTOToUserEntity(reqDTO)).thenReturn(UserTestUtility.userDTOToUserEntity(reqDTO));
		when(this.usersServiceImpl.addUser(reqDTO)).thenReturn(UserTestUtility.generateResponseUserDTO());
		ResponseUserDTO response = UserTestUtility.generateResponseUserDTO();
		
		assertEquals(reqDTO.getName(), response.getName());
        assertEquals(reqDTO.getEmail(), response.getEmail());
	}
	
	@Test
	void addUserFaildEmailTest() throws TechnicalBciException {
		RequestUserDTO reqDTO = UserTestUtility.generateRequestUserDTOFaildEmail();
		assertThrows(TechnicalBciException.class, () -> this.usersServiceImpl.addUser(reqDTO));
	}
	
	@Test
	void addUserFaildPasswordTest() throws TechnicalBciException {
		RequestUserDTO reqDTO = UserTestUtility.generateRequestUserDTOFaildPassword();
		assertThrows(TechnicalBciException.class, () -> this.usersServiceImpl.addUser(reqDTO));
	}
}
