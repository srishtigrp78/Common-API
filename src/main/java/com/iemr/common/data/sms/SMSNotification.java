package com.iemr.common.data.sms;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_smsnotification")
@Data
public class SMSNotification
{
	@Transient
	public static final int NOT_SENT = 0;
	@Transient
	public static final int IN_PROGRESS = 1;
	@Transient
	public static final int SENT = 2;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMSNotificationID")
	Long smsNotificatioID;
	@Column(name = "SMSTemplateID")
	Integer smsTemplateID;
	@Column(name = "PhoneNo")
	String phoneNo;
	@Column(name = "SMS")
	String sms;
	@Column(name = "SMSTriggerDate")
	Timestamp smsTriggerDate;
	@Column(name = "SMSSentDate")
	Timestamp smsSentDate;
	@Column(name = "SMSStatus")
	Integer smsStatus;
	@Column(name = "ProviderServiceMapID")
	Integer providerServiceMapID;
	@Column(name = "SenderID")
	Integer senderID;
	@Column(name = "BeneficiaryRegID")
	Long beneficiaryRegID;
	@Column(name = "BenCallID")
	Long benCallID;
	@Column(name = "ReceivingUserID")
	Long receivingUserID;
	@Column(name = "Deleted", insertable = false, updatable = false)
	Boolean deleted;
	@Column(name = "CreatedBy", insertable = true, updatable = false)
	String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	Timestamp createdDate;
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	Timestamp lastModDate;
	@Column(name = "TransactionID")
	String transactionID;
	@Column(name = "isTransactionError")
	Boolean isTransactionError;
	@Column(name = "TransactionError")
	String transactionError;

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
}
