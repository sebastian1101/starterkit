package com.capgemini.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.capgemini.enums.Function;

@Entity
@Table(name = "WORKERS2PROJECTS")
@NamedQueries({
		@NamedQuery(name = "workers2projects.findActualWorkersInProject", query = "select e from Workers2ProjectsEntity a join a.worker e join a.project p where a.dateTo is null or (a.dateTo > CURRENT_DATE) and p.name = :name"), 
		@NamedQuery(name = "workers2projects.findWorkersInvolvedLongerThanXMonthsInProject", query ="select e from Workers2ProjectsEntity a join a.worker e  join a.project p where  p.name = :name  and ( (( TIMESTAMPDIFF(SQL_TSI_MONTH , a.dateSince, CURRENT_DATE)  > :nMonth) and a.dateTo is null ) or  ( TIMESTAMPDIFF(SQL_TSI_MONTH , a.dateSince, a.dateTo) > :nMonth))")
})
public class Workers2ProjectsEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private WorkerEntity worker;

	@ManyToOne(fetch = FetchType.EAGER)
	private ProjectEntity project;

	@Enumerated(EnumType.STRING)
	private Function functionType;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dateSince;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dateTo;

	public Workers2ProjectsEntity(WorkerEntity worker, ProjectEntity project, Function functionType) {
		this.worker = worker;
		this.project = project;
		this.functionType = functionType;
	}

	public Workers2ProjectsEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WorkerEntity getWorker() {
		return worker;
	}

	public void setWorker(WorkerEntity worker) {
		this.worker = worker;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public Function getFunctionType() {
		return functionType;
	}

	public void setFunctionType(Function functionType) {
		this.functionType = functionType;
	}

	public Date getDateSince() {
		return dateSince;
	}

	public void setDateSince(Date dateSince) {
		this.dateSince = dateSince;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
