package com.exercise.bci.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.exercise.bci.dto.user.RequestUserDTO;
import com.exercise.bci.dto.user.ResponseUserDTO;
import com.exercise.bci.entity.UserEntity;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    ResponseUserDTO userEntityToUserDTO( UserEntity user );

    ResponseUserDTO userEntityToUserDTO( UserEntity user, String token );

    UserEntity userDTOToUserEntity( RequestUserDTO user );

}
