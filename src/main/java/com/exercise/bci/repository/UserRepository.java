package com.exercise.bci.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exercise.bci.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query( "SELECT user " +
            "  FROM User user " +
            " WHERE LOWER( user.email ) = LOWER( :email ) " +
            "   AND user.password = :password " 
    )
    public UserEntity retrieveByEmailAndPassword(
            @Param( value = "email" ) String email,
            @Param( value = "password" ) String password
    );
    
    public UserEntity findByEmail(String email);

}
