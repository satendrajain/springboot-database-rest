package com.assesment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servicemaster {

	@Id
	private String servicename;

	public String getServicename() {
		return servicename;
	}

	public Servicemaster(String servicename, String module) {
		super();
		this.servicename = servicename;
		this.module = module;
	}

	@Override
	public String toString() {
		return "Servicemaster [servicename=" + servicename + ", module=" + module + "]";
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	private String module;

	public Servicemaster() {
	}
}
