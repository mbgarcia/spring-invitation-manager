package com.party.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="guest")
public class Guest {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	@NotBlank(message="Field cannot be empty")
	@Size(max=40)
	private String name;
	
	@Column
	@NotBlank(message="Field cannot be empty")
	@Size(max=2)
	private String companions;
	
	public Guest() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanions() {
		return companions;
	}

	public void setCompanions(String companions) {
		this.companions = companions;
	}
}
