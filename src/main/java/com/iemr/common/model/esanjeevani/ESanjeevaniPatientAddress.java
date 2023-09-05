package com.iemr.common.model.esanjeevani;

import lombok.Data;

@Data
public class ESanjeevaniPatientAddress {
	
    public String addressLine1;
    public String addressType;
    public String addressUse;
    public int blockCode;
    public String blockDisplay;
    public int cityCode;
    public String cityDisplay;
    public String countryCode;
    public String countryDisplay;
    public int districtCode;
    public String districtDisplay;
    public String postalCode;
    public int stateCode;
    public String stateDisplay;

}
