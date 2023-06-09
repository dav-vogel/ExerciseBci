package com.exercise.bci.dto.user;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ResponseUserDTO extends UserDTO {

	private UUID id;
    
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy hh:mm:ss a" )
    private LocalDateTime created;
    
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy hh:mm:ss a" )
    private LocalDateTime lastLogin;
    
    @JsonProperty("is_active")
    private Boolean isActive;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
