package com.capgemini.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SECTION")
@NamedQuery(name = "sectionEntity.findSectionByName", query = "select f from SectionEntity f where f.sectionName = :sectionName")
public class SectionEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 15)
	private String sectionName;

	@Embedded
	private ContactData contactData;

	public SectionEntity() {
	}

	public SectionEntity(final String section) {
		this.sectionName = section;
	}

	/* getters and setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSection() {
		return sectionName;
	}

	public void setSection(String section) {
		this.sectionName = section;
	}

	public ContactData getContactData() {
		return contactData;
	}

	public void setContactData(ContactData contactData) {
		this.contactData = contactData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
