package com.asiantech.jpa.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name = "accountjpa")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	@NotNull
	@Size(min = 2, max = 8, message = "Username must be between 2 and 8 characters long.")
	private String name;
	@NotNull
	@Size(min = 2, max = 8, message = "Username must be between 2 and 8 characters long.")
	private String firstname;
	@NotNull
	@Size(min = 2, max = 8, message = "Username must be between 2 and 8 characters long.")
	private String lastname;
	@NotNull
	private String status;
	@NotNull
	private boolean sex=false;

    public Account(){}
	public Account(int id, String name, String firstname, String lastname,
			String status, boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	
}
