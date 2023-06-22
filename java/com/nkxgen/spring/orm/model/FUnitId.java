package com.nkxgen.spring.orm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class FUnitId implements Serializable {
	@ManyToOne
	@JoinColumn(name = "modl_id")
	private Module module;

	@Column(name = "funt_id")
	private int funitid;

	public FUnitId() {
		// Default constructor required by JPA
	}

	public FUnitId(Module module, int funitid) {
		this.module = module;
		this.funitid = funitid;
	}

	// Getters and setters
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public int getFunitid() {
		return funitid;
	}

	public void setFunitid(int funitid) {
		this.funitid = funitid;
	}

	// Implement equals and hashCode methods based on module and funitid

	// Other methods
}
