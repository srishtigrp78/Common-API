package com.iemr.common.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.users.EmployeeSignature;
import com.iemr.common.repository.users.EmployeeSignatureRepo;

@Service
public class EmployeeSignatureServiceImpl implements EmployeeSignatureService {

	@Autowired
	EmployeeSignatureRepo employeeSignatureRepo;

	

	@Override
	public EmployeeSignature fetchSignature(Long userSignID) {
		// TODO Auto-generated method stub
		return employeeSignatureRepo.findOneByUserID(userSignID);
	}

	public Boolean existSignature(Long userID) {
		// TODO Auto-generated method stub
		return employeeSignatureRepo.countByUserIDAndSignatureNotNull(userID)>0;
	}

}
