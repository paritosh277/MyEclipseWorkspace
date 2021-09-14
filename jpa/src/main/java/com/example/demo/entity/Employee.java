package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the employees")
@Entity
@Table(name = "employee")
public class Employee {
	
	@ApiModelProperty(notes = "The Unique id of the employee")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@ApiModelProperty(notes = "The employee's first Name")
	@NotNull
	@Size(min = 2, message = "First Name should have at least 2 characters")
	@Column(name = "first_name")
	private String firstName;
	
	@ApiModelProperty(notes = "The employee's last Name")
	@NotNull(message = "Lastname should not be null")
	@Size(min=2, message = "Second Name should have at least 2 characters")
	@Column(name = "last_name")
	private String lastName;
	
	@ApiModelProperty(notes = "The employee's Email")
	@NotBlank(message="Email should not be blank")
	@Email
	@Column(name = "email")
	private String email;
	
	
	

	public Employee() {
	
	}

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
}
