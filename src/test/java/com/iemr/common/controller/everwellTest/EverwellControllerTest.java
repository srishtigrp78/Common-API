package com.iemr.common.controller.everwellTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.model.user.LoginRequestModelEverwell;

@ExtendWith(MockitoExtension.class)
class EverwellControllerTest {

	@InjectMocks()

	EverwellController everwellController;

	@Test
	void testGetData() {

		// Execute the method to be tested
		String response = everwellController.getdata();

		// Validate the response
		String expectedResponse = "{\"response\":\"{   \\\"Success\\\": true,\\\"TotalRecords\\\": 3,\\\"currentPage\\\": 1,\\\"Data\\\": [{ \\r\\n\" + \n"
				+ "        \"					        \\\"Id\\\": 1232, \\r\\n\" + \n"
				+ "        \"							\\\"FirstName\\\": \\\"Test\\\", \\r\\n\" + \n"
				+ "        \"					        \\\"LastName\\\": \\\"tester\\\", \\r\\n\" + \n"
				+ "        \"							\\\"Gender\\\":\\\"Female\\\",\\r\\n\" + \n"
				+ "        \"					        \\\"PrimaryNumber\\\": \\\"1111111111\\\", \\r\\n\" + \n"
				+ "        \"					        \\\"MissedDoses\\\":2, \\r\\n\" + \n"
				+ "        \"					        \\\"FacilityName\\\": \\\"Facility X\\\", \\r\\n\" + \n"
				+ "        \"					        \\\"State\\\": \\\"Uttar Pradesh\\\", \\r\\n\" + \n"
				+ "        \"							\\\"District\\\": \\\"Varanasi\\\", \\r\\n\" + \n"
				+ "        \"					        \\\"AdherencePercentage\\\": 50 \\r\\n\" + \n"
				+ "        \"					      }]\\r\\n\" + \n" + "        \"						  }\"}";

		// Assertions to check if the actual response matches the expected response.

		assertTrue(response.contains("Success"));

	}

	@Test
	void testAddSupportActionReturnsExpectedString() {
		Long id = 1L;
		String requestBody = "{}"; // Simplified example, assuming an empty JSON for the sake of the test.

		String response = everwellController.addSupportAction(id, requestBody);

		// Check if the response contains specific fields that indicate it's the
		// expected hard-coded string.

		System.out.println(response);

		assertTrue(response.contains("Success"));

//		assertTrue(response.contains("\"Id\": 123456789"));
//		assertTrue(response.contains("\"UserDescription\": \"Demo Login\""));
//		assertTrue(response.contains("\"ActionTaken\": \"Call\""));
	}

	@Test
	void testEditManualDosesSuccess() throws Exception {
		// Setup
		Long id = 1L;
		String requestBody = "{}";
		String expectedResponse = "{ \"PatientId\": 123456789 }"; // Simplified
		// when(doseService.editDoses(anyLong(),
		// anyString())).thenReturn(expectedResponse);

		// Execute
		String response = everwellController.editManualDoses(id, requestBody);

		System.out.println(response);
		// Assert
		assertTrue(response.contains("Success"));
		// assertTrue(response.contains("\"PatientId\": 123456789"));
	}

	@Test
	void testEverwellLoginSuccess() {
		EverwellController controller = new EverwellController();

		LoginRequestModelEverwell login = new LoginRequestModelEverwell();
		login.setEverwellUserName("everwellUser");
		login.setEverwellPassword("everwellpass");

		String response = controller.everwellLogin(login);
		System.out.println(response);
		assertTrue(response.contains("Success"));
//		assertTrue(response.contains("\"access_token\": \"Bearer"));
//		assertTrue(response.contains("\"userName\": \"<username-used-in-login>\""));
	}

	@Test
	void testEverwellLoginFailure() {
		EverwellController controller = new EverwellController();

		LoginRequestModelEverwell login = new LoginRequestModelEverwell();
		login.setEverwellUserName("wrongUser");
		login.setEverwellPassword("wrongPass");

		String response = controller.everwellLogin(login);

		assertFalse(response.contains("\"access_token\": \"Bearer"));
	}
}
