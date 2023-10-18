package com.iemr.common.model.esanjeevani;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class ESanjeevaniPatientRegistration {

    public String abhaAddress;
    public String abhaNumber;
    public int age;
    public String birthdate;
    public String displayName;
    public String firstName;
    public String middleName;
    public String lastName;
    public int genderCode;
    public String genderDisplay;
    public boolean isBlock;
    public String source;
    
    public ArrayList<ESanjeevaniPatientAddress> lstPatientAddress;
    public ArrayList<ESanjeevaniPatientContactDetail> lstPatientContactDetail;

}
