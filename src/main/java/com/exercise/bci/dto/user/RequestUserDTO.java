package com.exercise.bci.dto.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestUserDTO extends UserDTO {

	@NotNull( message = "The password is mandatory." )
    @NotEmpty( message = "The password cannot be empty." )
    @JsonProperty("password")
    private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
