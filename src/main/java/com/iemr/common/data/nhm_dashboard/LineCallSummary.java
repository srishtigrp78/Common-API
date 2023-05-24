package com.iemr.common.data.nhm_dashboard;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "t_linecallsummary")
public class LineCallSummary {
	
	@Id
    @GeneratedValue
    @Column(name = "id", insertable = false)
    private Long id;     
    @Column(name = "LineNumber")
    private String lineNumber;     
    @Column(name = "CampaignName")
    private String campaignName;    
    @Column(name = "TotalCalls")
    private Integer totalCalls;
    @Column(name = "TotalTalkTime")
    private Time totalTalkTime;
    @Column(name = "AverageTalkTime")
    private Time averageTalkTime;    
    @Column(name = "Deleted", insertable = false, updatable = true)
    private Boolean deleted;
    @Column(name = "Processed")
	private String processed;
    @Column(name = "CreatedBy", updatable = false)
    private String createdBy;     
    @Column(name = "CreatedDate", insertable = false, updatable = false)
    private Timestamp createdDate;     
    @Column(name = "ModifiedBy", insertable = false, updatable = true)
    private String modifiedBy;     
    @Column(name = "LastModDate", insertable = false, updatable = false)
    private Timestamp lastModDate;


}
