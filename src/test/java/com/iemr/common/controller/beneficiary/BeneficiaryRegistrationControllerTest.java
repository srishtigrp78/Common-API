package com.iemr.common.controller.beneficiary;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.model.beneficiary.BeneficiaryModel;
import com.iemr.common.service.beneficiary.BenRelationshipTypeService;
import com.iemr.common.service.beneficiary.BeneficiaryOccupationService;
import com.iemr.common.service.beneficiary.GovtIdentityTypeService;
import com.iemr.common.service.beneficiary.IEMRBeneficiaryTypeService;
import com.iemr.common.service.beneficiary.IEMRSearchUserService;
import com.iemr.common.service.beneficiary.RegisterBenificiaryService;
import com.iemr.common.service.beneficiary.RegisterBenificiaryServiceImpl;
import com.iemr.common.service.beneficiary.SexualOrientationService;
import com.iemr.common.service.callhandling.CalltypeService;
import com.iemr.common.service.directory.DirectoryService;
import com.iemr.common.service.location.LocationService;
import com.iemr.common.service.userbeneficiarydata.CommunityService;
import com.iemr.common.service.userbeneficiarydata.EducationService;
import com.iemr.common.service.userbeneficiarydata.GenderService;
import com.iemr.common.service.userbeneficiarydata.LanguageService;
import com.iemr.common.service.userbeneficiarydata.MaritalStatusService;
import com.iemr.common.service.userbeneficiarydata.StatusService;
import com.iemr.common.service.userbeneficiarydata.TitleService;
import com.iemr.common.utils.mapper.InputMapper;

public class BeneficiaryRegistrationControllerTest {

	private static InputMapper inputMapper = new InputMapper();

	private static RegisterBenificiaryService registerBenificiaryService;
	private static IEMRBeneficiaryTypeService iemrBeneficiaryTypeService;
	private static IEMRSearchUserService iemrSearchUserService;
	private static EducationService educationService;
	private static TitleService titleService;
	private static StatusService statusService;
	private static LocationService locationService;
	private static GenderService genderService;
	private static MaritalStatusService maritalStatusService;
	private static CommunityService communityService;
	private static DirectoryService directoryService;
	private static SexualOrientationService sexualOrientationService;
	private static LanguageService languageService;
	private static BenRelationshipTypeService benRelationshipTypeService;
	private static BeneficiaryOccupationService beneficiaryOccupationService;
	private static GovtIdentityTypeService govtIdentityTypeService;
	private static CalltypeService calltypeService;
	private static BeneficiaryModel benPos;
	private static BeneficiaryModel benNeg;
	static String benData = "{i_bendemographics:{},benPhoneMaps:[{}]}";

	@Before
	public void makeBenefciaryRegistration() {
//		try {
//			registerBenificiaryService = mock(RegisterBenificiaryServiceImpl.class);
//			benPos = inputMapper.gson().fromJson(benData, BeneficiaryModel.class);
//			benNeg = inputMapper.gson().fromJson(benData, BeneficiaryModel.class);
//			benNeg.setBeneficiaryRegID(0L);
//			//when(registerBenificiaryService.updateBenificiary(benPos,"")).thenReturn(1);
//			//when(registerBenificiaryService.updateBenificiary(benNeg)).thenReturn(0);
//		} catch (Exception e) {
//			fail("failed with error " + e.getMessage());
//		}
	}

	@Test
	public void updateBeneficiaryTest() {
//		//assertTrue("Updated beneficiary with ben id " + benPos.getBeneficiaryID(),
//		//		registerBenificiaryService.updateBenificiary(benPos) == 1);
// 	int update = registerBenificiaryService.updateBenificiary(benPos);
//		assertEquals(update, 0);
	}

}
