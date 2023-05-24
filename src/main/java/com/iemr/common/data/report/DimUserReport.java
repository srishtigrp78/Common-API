package com.iemr.common.data.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "db_reporting.dim_user", schema = "db_reporting")
public class DimUserReport implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "Dim_USERID", insertable = false, updatable = false)
	private Long dim_USERID;
	
	@Expose
	@Column(name = "UserID")
	private Long userID;
	
	@Expose
	@Column(name = "EmployeeID")
	private String empID;
	
	@Expose
	@Column(name="FirstName")
	private String firstName;
	
/*	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", referencedColumnName = "UserID", updatable = false, insertable = false)
	@Expose
	private UserServiceRoleReport userServiceRoleReport;*/

	/**
	 * @return the dim_USERID
	 */
	public Long getDim_USERID() {
		return dim_USERID;
	}

	/**
	 * @param dim_USERID the dim_USERID to set
	 */
	public void setDim_USERID(Long dim_USERID) {
		this.dim_USERID = dim_USERID;
	}

	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}

	/**
	 * @return the empID
	 */
	public String getEmpID() {
		return empID;
	}

	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public DimUserReport()
	{
		super();
	}
}
