package com.example.onetomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Parent {
	@Id
	@Column(name="PARENT_ID")
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy="parent")
	List<Child> child = new ArrayList<Child>();
}
