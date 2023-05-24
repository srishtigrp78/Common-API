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
import com.iemr.common.data.users.WorkLocation;

import lombok.Data;

@Data
@Entity
@Table(name = "db_iemr.m_userservicerolemapping", schema = "db_iemr")
public class UserServiceRoleReport implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "USRMappingID")
	private Long USRMappingID;

	@Expose
	@Column(name = "UserID")
	private Long UserID;
	
	@Expose
	@Column(name = "RoleID")
	private Long roleID;
	
	@Expose
	@Column(name = "WorkingLocationID")
	private Long WorkingLocationID;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WorkingLocationID", referencedColumnName = "PSAddMapID", updatable = false, insertable = false)
	@Expose
	private WorkLocation workLocation;
}
