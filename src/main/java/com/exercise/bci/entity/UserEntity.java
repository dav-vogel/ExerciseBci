package com.exercise.bci.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity( name = "User" )
@Table(
        name = "MY_USER",
        indexes = {
                @Index(
                        name = "idx_myuser_email",
                        columnList = "email",
                        unique = true
                )
        }
)
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -3238938715592527781L;

	@Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            columnDefinition = "BINARY(16)"
    )
    @GeneratedValue
    private UUID id;

    @Column( name = "created", columnDefinition="TIMESTAMP" )
    private LocalDateTime created;

    @Column( name = "last_login", columnDefinition="TIMESTAMP" )
    private LocalDateTime lastLogin;

    @Column( name = "is_active" )
    private Boolean isActive;

    @Column( name = "name" )
    private String name;

    @NotNull( message = "The email is mandatory" )
    @NotEmpty( message = "The email cannot be empty" )
    @Email( message = "Email should be valid" )
    @Column( name = "email", nullable = false )
    private String email;

    @NotNull( message = "The password is mandatory" )
    @NotEmpty( message = "The password cannot be empty" )
    @Column( name = "password", nullable = false )
    private String password;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn( name = "user_id" )
    private Set<PhoneEntity> phones;

    @PrePersist
    private void prePersist(){
        this.created = LocalDateTime.now();
    }
    
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneEntity> phones) {
		this.phones = phones;
	}
}
