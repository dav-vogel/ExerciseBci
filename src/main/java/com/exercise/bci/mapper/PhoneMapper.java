package com.exercise.bci.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.exercise.bci.dto.user.PhoneDTO;
import com.exercise.bci.entity.PhoneEntity;


@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper( PhoneMapper.class );

    PhoneDTO phoneEntityToPhoneDTO( PhoneEntity phone );

    @Mapping( target = "userId", ignore = true )
    PhoneEntity phoneDTOToPhoneEntity( PhoneDTO phone );
}
