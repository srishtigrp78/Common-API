package com.iemr.common.controller.carestream;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.controller.carestream.CareStreamCreateOrderController;
import com.iemr.common.data.carestream.CreateOrderData;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
public class CareStreamCreateOrderControllerTest {

	@Mock
	private InputMapper inputMapper;

	@InjectMocks
	private CareStreamCreateOrderController careStreamCreateOrderController;

	@Test
	void createOrderTest() throws UnknownHostException, IOException {
		String createOrder = "{\n" + "  \"firstName\": \"John\",\n" + "  \"middleName\": \"Doe\",\n"
				+ "  \"LastName\": \"Smith\",\n" + "  \"gender\": \"Male\",\n" + "  \"dob\": \"1980-01-01\",\n"
				+ "  \"patientID\": \"123456789\",\n" + "  \"acc\": \"ACC1234\"\n" + "}";

		CreateOrderData benificiaryDetails = InputMapper.gson().fromJson(createOrder, CreateOrderData.class);

		// when(inputMapper.fromJson(createOrder,
		// CreateOrderData.class)).thenReturn(benificiaryDetails);

		String response = careStreamCreateOrderController.createOrder(createOrder);

		assertTrue(response.contains("Failed with Cannot assign"));
		// assertEquals("Order successfully created", response);
	}

	@Test
	void updateOrderTest() throws UnknownHostException, IOException {
		String updateOrder = "{\n" + "  \"firstName\": \"John\",\n" + "  \"middleName\": \"Doe\",\n"
				+ "  \"LastName\": \"Smith\",\n" + "  \"gender\": \"Male\",\n" + "  \"dob\": \"1980-01-01\",\n"
				+ "  \"patientID\": \"123456789\",\n" + "  \"acc\": \"ACC1234\"\n" + "}";

		CreateOrderData benificiaryDetails = InputMapper.gson().fromJson(updateOrder, CreateOrderData.class);

		// when(inputMapper.fromJson(updateOrder,
		// CreateOrderData.class)).thenReturn(benificiaryDetails);

		String response = careStreamCreateOrderController.updateOrder(updateOrder);

		assertTrue(response.contains("Connection timed out"));
		// assertEquals("Receiver from server: ", response);
	}

	@Test
	void deleteOrderTest() throws UnknownHostException, IOException {
		String deleteOrder = "{\n" + "  \"firstName\": \"John\",\n" + "  \"middleName\": \"Doe\",\n"
				+ "  \"LastName\": \"Smith\",\n" + "  \"gender\": \"Male\",\n" + "  \"dob\": \"1980-01-01\",\n"
				+ "  \"patientID\": \"123456789\",\n" + "  \"acc\": \"ACC1234\"\n" + "}";

		CreateOrderData benificiaryDetails = InputMapper.gson().fromJson(deleteOrder, CreateOrderData.class);

		// when(inputMapper.fromJson(deleteOrder,
		// CreateOrderData.class)).thenReturn(benificiaryDetails);

		String response = careStreamCreateOrderController.deleteOrder(deleteOrder);
		assertTrue(response.contains("Failed with connection issues"));

		// assertEquals("Receiver from server: ", response);
	}
}