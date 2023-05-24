package com.iemr.common.dto.identity;

import java.util.List;

import com.iemr.common.model.beneficiary.BenPhoneMapModel;

import lombok.Data;

@Data
public class Contact {

	private String preferredPhoneNum;
	private String preferredPhoneTyp;
	private String preferredSMSPhoneNum;
	private String preferredSMSPhoneTyp;
	private String emergencyContactNum;
	private String emergencyContactTyp;
	private String phoneNum1;
	private String phoneTyp1;
	private String phoneNum2;
	private String phoneTyp2;
	private String phoneNum3;
	private String phoneTyp3;
	private String phoneNum4;
	private String phoneTyp4;
	private String phoneNum5;
	private String phoneTyp5;

	public static Contact addContacts(List<BenPhoneMapModel> benPhoneMapModels) {
		Contact contact = new Contact();
		// BenPhoneMapModel ben = benPhoneMapModels.get(0);
		for (int i = 0; i < benPhoneMapModels.size(); i++) {
			BenPhoneMapModel ben = benPhoneMapModels.get(i);
			switch (i) {
			case 0:
				contact.setPreferredPhoneNum(ben.getPhoneNo());
				contact.setPreferredPhoneTyp(ben.getPhoneTypeName());
				contact.setPreferredSMSPhoneNum(ben.getPhoneNo());
				contact.setPreferredSMSPhoneTyp(ben.getPhoneTypeName());
				if (ben.getAlternateContactNumber() != null) {
					contact.setEmergencyContactNum(ben.getAlternateContactNumber());
					contact.setEmergencyContactTyp("alternate contact no");
				}
				break;
			case 1:
				contact.setPhoneNum1(ben.getPhoneNo());
				contact.setPhoneTyp1(ben.getPhoneTypeName());
				break;
			case 2:
				contact.setPhoneNum2(ben.getPhoneNo());
				contact.setPhoneTyp2(ben.getPhoneTypeName());
				break;
			case 3:
				contact.setPhoneNum3(ben.getPhoneNo());
				contact.setPhoneTyp3(ben.getPhoneTypeName());
				break;
			case 4:
				contact.setPhoneNum4(ben.getPhoneNo());
				contact.setPhoneTyp4(ben.getPhoneTypeName());
				break;

			case 5:
				contact.setPhoneNum5(ben.getPhoneNo());
				contact.setPhoneTyp5(ben.getPhoneTypeName());
				break;
			}
		}

		return contact;
	}

}
