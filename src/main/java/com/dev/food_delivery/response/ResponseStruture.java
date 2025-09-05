package com.dev.food_delivery.response;

import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * @author Atul
 */
@Data
@Component
public class ResponseStruture<T> {

	private int status;
	private String message;
	private T data;
}
