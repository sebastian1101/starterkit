package com.capgemini.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostUpdate;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {
	
	@Column(name = "last_modified", columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Date lastModified;

	@Column(name = "creation_date", columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Timestamp timeOfCreation;
	
	@Version
	@Column(name = "version", columnDefinition = "INT default 1", nullable = false)
	private int version;
	
	@PostUpdate
	public void setLastModified() {
		lastModified = new Date();
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Timestamp getTimeOfCreation() {
		return timeOfCreation;
	}

	public void setTimeOfCreation(Timestamp timeOfCreation) {
		this.timeOfCreation = timeOfCreation;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
