package com.example.demo.users.entity;

public class BadRequestException extends RuntimeException{
	public BadRequestException(String message) {
		super(message);
	}

}
