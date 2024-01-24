/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.data.report;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.users.WorkLocation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
