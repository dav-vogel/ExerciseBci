package com.exercise.bci.dto.user;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    
    @JsonProperty("token")
    private String token;

    @JsonProperty("name")
    private String name;
    
    @NotNull( message = "El e-mail es obligatorio." )
    @NotEmpty( message = "El e-mail no puede ser vacío." )
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("phones")
    private Set<PhoneDTO> phones;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneDTO> phones) {
		this.phones = phones;
	}
}
