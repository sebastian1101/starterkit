package com.capgemini.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.enums.ProjectType;

@Entity
@Table(name = "PROJECT")
public class ProjectEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, length = 15)
    private String name;
	
	@OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
	private Collection<Workers2ProjectsEntity> workers2projects;
	
	@Enumerated(EnumType.STRING)
	private ProjectType type;
	
	@Column(nullable = false)
    private double salary;
	
	public ProjectEntity() {
		
	}
	
	public ProjectEntity( final String name, final ProjectType type, final double salary) {
		this.name = name;
		this.type = type;
		this.salary = salary;
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

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
