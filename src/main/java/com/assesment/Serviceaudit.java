package com.assesment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Serviceaudit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String servicename;
	private String branchname;
	private String environment;
	private String timestamp;

	public Serviceaudit() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Serviceaudit [id=" + id + ", servicename=" + servicename + ", branchname=" + branchname
				+ ", environment=" + environment + ", timestamp=" + timestamp + "]";
	}

	public Serviceaudit(String servicename, String branchname, String environment, String timestamp) {
		super();
		this.servicename = servicename;
		this.branchname = branchname;
		this.environment = environment;
		this.timestamp = timestamp;
	}

}
