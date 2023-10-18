package com.iemr.common.model.esanjeevani;

import lombok.Data;

@Data
public class ESanjeevaniProviderAuth {

	private String userName;
	private String password;
	private String salt;
	private String source;
}
