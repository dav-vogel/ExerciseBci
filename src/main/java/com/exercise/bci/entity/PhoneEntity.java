package com.exercise.bci.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity( name = "Phone" )
@Table(
        name = "MY_PHONE",
        indexes = {
                @Index(
                        name = "idx_myphone_userid",
                        columnList = "user_id"
                )
        }
)
public class PhoneEntity implements Serializable {

	private static final long serialVersionUID = -3621476115778158208L;

	@Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            columnDefinition = "BINARY(16)"
    )
    @GeneratedValue
    private UUID id;

    @Column( name = "user_id", columnDefinition = "BINARY(16)" )
    private UUID userId;

    @Column( name = "number" )
    private Long number;

    @Column( name = "city_code" )
    private Integer cityCode;

    @Column( name = "country_code" )
    private String countryCode;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
