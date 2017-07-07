package com.example.onetomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Child {
	@Id
	@Column(name="CHILD_ID")
	@GeneratedValue
	private long id;
	
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	private Parent parent;
}
