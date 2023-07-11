package com.example.fooddeliveryproject.authmodels;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserSessionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private Integer userId;
	private String UUID;
	private LocalDateTime timeStamp;
	
	public UserSessionEntity() {
		super();
	}

	public UserSessionEntity(Integer userId, String uUID, LocalDateTime timeStamp) {
		super();
		this.userId = userId;
		this.UUID = uUID;
		this.timeStamp = timeStamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "UserSessionEntity [id=" + id + ", userId=" + userId + ", UUID=" + UUID + ", timeStamp=" + timeStamp
				+ "]";
	}

	public static UserSessionEntity getUserSessionEntity(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
