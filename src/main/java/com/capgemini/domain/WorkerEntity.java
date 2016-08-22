package com.capgemini.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "WORKER")
@NamedQuery(name="worker.findWorkerBySectionName", query="select b from WorkerEntity b join b.section a where a.sectionName = :sectionName")
public class WorkerEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 15)
	private String name;

	@Column(nullable = false, length = 15)
	private String surname;

	@Column(nullable = false, length = 15)
	private String pesel;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", columnDefinition = "DATE", nullable = false)
	private Date birthDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private SectionEntity section;
	
	@OneToMany(mappedBy = "worker",cascade = CascadeType.ALL)
	private Collection<Workers2ProjectsEntity> workers2projects;

	@Embedded
	private ContactData contactData;

	public WorkerEntity(final String name, final String surname, final String pesel) {
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
	}

	// for hibernate
	public WorkerEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public SectionEntity getSection() {
		return section;
	}

	public void setSection(SectionEntity section) {
		this.section = section;
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
