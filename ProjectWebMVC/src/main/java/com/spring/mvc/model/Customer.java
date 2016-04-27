package com.spring.mvc.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer", catalog = "test")
public class Customer implements java.io.Serializable {

	private Integer id;
	private String name;
	private String age;

	public Customer() {
		super();
	}

	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Customer(Integer id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
