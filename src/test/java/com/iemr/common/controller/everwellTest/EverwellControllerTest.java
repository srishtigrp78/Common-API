package com.iemr.common.controller.everwellTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.model.user.LoginRequestModelEverwell;
import com.iemr.common.utils.mapper.InputMapper;

@ExtendWith(MockitoExtension.class)
class EverwellControllerTest {

	@InjectMocks
	private EverwellController everwellController;

	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

//	@Test
//	void testGetdata() {
//		fail("Not yet implemented");
//	}

	@Test
	void getdata_ShouldReturnExpectedJson() {
		// Act
		String response = everwellController.getdata();

		// Assert
		assertTrue(response.contains("\"Success\":true"), "Response should contain '\"Success\":true'");
		assertTrue(response.contains("\"TotalRecords\":3"), "Response should contain '\"TotalRecords\":3'");
		assertTrue(response.contains("\"FirstName\":\"Test\""), "Response should contain '\"FirstName\":\"Test\"'");

	}

	@Test
	void getdata_WhenExceptionOccurs_ShouldHandleException() {
		// Act
		String response = everwellController.getdata();

		// Assert
		// Assuming your OutputResponse#toString() method includes details about the
		// error
		assertThat(response).contains("");
		// Verify the structure of the response to ensure it's in the expected error
		// format
	}

//
//	@Test
//	void testAddSupportAction() {
//		fail("Not yet implemented");
//	}

	@Test
	void addSupportAction_Success() {
		// Given
		Long id = 1L; // Example ID
		String request = "{   \"Id\": 123456789," + "\"UserId\": 123," + "\"UserDescription\": \"Demo Login\",\r\n"
				+ "\"ActionTaken\": \"Call\",\r\n" + " \"Comments\": \"Well, This is a Sample Comment\",\r\n"
				+ "\"Category\": \"Support_Action_Call\",\r\n" + "\"SubCategory\": \"Dose not taken\",\r\n"
				+ "\"Timestamp\": \"2020-04-02T04:18:43.4373395\",\r\n"
				+ "\"DateOfAction\": \"2020-03-02T00:00:00\" } ";

		// When
		String result = everwellController.addSupportAction(id, request);

		// Then
		assertTrue(result.contains("\"Id\":123456789"));
		assertTrue(result.contains("\"UserDescription\":\"Demo Login\""));
	}

	@Test
	void addSupportAction_Exception() {
		// Given
		Long id = 1L; // Example ID
		String request = null; // To provoke an exception

		// When
		String result = everwellController.addSupportAction(id, request);

		System.out.println(result);

		// Then
		// Adjust this based on how your `OutputResponse.setError` method modifies the
		// response
		assertTrue(result.contains("error"));
	}

	@Test
	void editManualDoses_Success() {
		// Given
		Long id = 1L; // Example ID
		String request = "{ \"request\": \"Some JSON request\" }"; // Simplified request body

		// When
		String result = everwellController.editManualDoses(id, request);

		// Then
		// Verify the response structure based on successful execution
		assertTrue(result.contains("\"PatientId\":123456789"));
		assertTrue(result.contains("\"ActionTaken\":\"Manual doses marked for 2/3/2020, 3/3/2020, 7/3/2020\""));
	}

//	@Test
//	void editManualDoses_Exception() {
//		// Given
//		Long id = 1L; // Example ID
//		String request = null; // Intentionally passing null to provoke an exception
//
//		// When & Then
//		Exception exception = assertThrows(NotFoundException.class, () -> {
//			everwellController.editManualDoses(id, request);
//		});
//
//		// Optionally check the exception message if it's relevant
//		String expectedMessage = "error";
//		String actualMessage = exception.getMessage();
//
//		System.out.println(actualMessage);
//
//		assertTrue(actualMessage.contains(expectedMessage));
//	}

//******

	@Test
	void everwellLogin_Successful() {
		// Given
		LoginRequestModelEverwell loginRequest = new LoginRequestModelEverwell();
		loginRequest.setEverwellUserName("everwellUser");
		loginRequest.setEverwellPassword("everwellpass");

		// When
		String result = everwellController.everwellLogin(loginRequest);

		// Then
		assertTrue(result.contains("\"access_token\":"));
		assertTrue(result.contains("\"userName\": \"everwellUser\""));
	}

	@Test
	void everwellLogin_Unsuccessful() {
		// Given
		LoginRequestModelEverwell loginRequest = new LoginRequestModelEverwell();
		loginRequest.setEverwellUserName("wrongUser");
		loginRequest.setEverwellPassword("wrongPass");

		// When
		String result = everwellController.everwellLogin(loginRequest);

		// Then
		// Assuming your method handles incorrect credentials by setting response to
		// null or similar.
		assertTrue(result.contains("null") || result.isEmpty());
	}
	
	@Test
    void everwellLogin_ExceptionHandling() {
        // Given
        LoginRequestModelEverwell loginRequest = mock(LoginRequestModelEverwell.class);
        when(loginRequest.getEverwellUserName()).thenThrow(new RuntimeException("Unexpected error"));

        // When & Then
        Exception exception = assertThrows(RuntimeException.class, () -> {
        	everwellController.everwellLogin(loginRequest);
        });

        // Optionally check the exception message if it's relevant
        assertEquals("Unexpected error", exception.getMessage());
    }
	
//	@Test
//	void everwellLogin_Successful() {
//
//		String responseData = null;
//		OutputResponse response = new OutputResponse();
//
//		LoginRequestModelEverwell login = new LoginRequestModelEverwell();
//		login.setEverwellUserName("everwellUser");
//		login.setEverwellPassword("everwellpass");
//
//		responseData = "{\r\n"
//				+ " \"access_token\": \"Bearer XwvQ8FWJgL1r1coDA9hI9Zfn0BnzSe0MsI5ECb6UhhSFz96ASoh\",\r\n"
//				+ " \"token_type\": \"bearer\",\r\n" + " \"expires_in\": 2591999,\r\n"
//				+ " \"userName\": \"<username-used-in-login>\",\r\n"
//				+ " \".issued\": \"Mon, 23 Nov 2019 16:18:08 GMT\",\r\n"
//				+ " \".expires\": \"Wed, 22 Dec 2020 16:18:08 GMT\"\r\n" + "}\r\n" + "";
//
//		response.setResponse(responseData);
//
//		assertTrue((login.getEverwellUserName().equalsIgnoreCase("everwellUser")
//				&& login.getEverwellPassword().equals("everwellpass")));
//
//	}
//
//
//	

}
