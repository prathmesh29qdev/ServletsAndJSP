package com.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * <h3>Register User Entity</h3>
 * <p>
 * This class is containing all the attributes for a particular user.
 * </p>
 * 
 * @author Prathmesh
 */
@Getter
@Setter
public class RegisterUser {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private long contact;
	private String email;
	private String address;

}