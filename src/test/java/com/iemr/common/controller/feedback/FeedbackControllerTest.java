package com.iemr.common.controller.feedback;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackLog;
import com.iemr.common.data.feedback.FeedbackResponse;
import com.iemr.common.data.feedback.FeedbackSeverity;
import com.iemr.common.data.feedback.FeedbackType;
import com.iemr.common.model.feedback.FeedbackListRequestModel;
import com.iemr.common.service.feedback.FeedbackRequestService;
import com.iemr.common.service.feedback.FeedbackResponseService;
import com.iemr.common.service.feedback.FeedbackService;
import com.iemr.common.service.feedback.FeedbackSeverityServiceImpl;
import com.iemr.common.service.feedback.FeedbackTypeService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class FeedbackControllerTest {

	private final FeedbackService feedbackServiceMock = mock(FeedbackService.class, "feedbackService");

	private final FeedbackRequestService feedbackRequestServiceMock = mock(FeedbackRequestService.class,
			"feedbackRequestService");

	private final FeedbackResponseService feedbackResponseServiceMock = mock(FeedbackResponseService.class,
			"feedbackResponseService");

	private final FeedbackSeverityServiceImpl feedbackSeverityServiceMock = mock(FeedbackSeverityServiceImpl.class,
			"feedbackSeverityService");

	private final FeedbackTypeService feedbackTypeServiceMock = mock(FeedbackTypeService.class, "feedbackTypeService");

	private AutoCloseable autoCloseableMocks;

	@InjectMocks()
	private FeedbackController target;

	@AfterEach()
	 void afterTest() throws Exception {
		if (autoCloseableMocks != null)
			autoCloseableMocks.close();
	}

	// Sapient generated method id: ${26e21eb2-bdcd-32fe-ada1-0ce60ddeaa62}, hash:
	// 99305F4A6ABF044076D1498067872474
	@Test()
	void feedbackRequestTest() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbackRequest("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	// Sapient generated method id: ${6545aa58-cc68-362f-9196-39fcdd85d80a}, hash:
	// 01CB2BF5DE71E5F487E0EBDBAE3837C8
	@Test()
	void feedbackRequestWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbackRequest("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	// Sapient generated method id: ${2b92493b-6ceb-3e43-82c4-7726522aaffa}, hash:
	// 769B14B3E58F567ACEB08DAA6F7B2549
	@Test()
	void getFeedbackByPostTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
		doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(2L);
		// Act Statement(s)
		String result = target.getFeedbackByPost(2L);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result,
					equalTo("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackRequests(2L);
		});
	}

	// Sapient generated method id: ${d583ae11-f9ef-34b5-a7f0-84965c2db24a}, hash:
	// 0ACF0750F3D61B4D1A9D24DA908AF74B
	@Test()
	void getFeedbackByPostWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
		doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(2L);
		// Act Statement(s)
		String result = target.getFeedbackByPost(2L);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result,
					equalTo("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackRequests(2L);
		});
	}

	// Sapient generated method id: ${a1b7f39b-3249-34b0-8bd8-7cb5035e9c71}, hash:
	// D22C6089C8ACA6F5651C566EA3CF07CC
	@Test()
	void createFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).saveFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.createFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedback("feedbackDetails1");
		});
	}

	// Sapient generated method id: ${79f80e19-1a9a-3e90-99f2-5dd7f0cfe2d9}, hash:
	// 63267D21D101C6994642F904A721D2C0
	@Test()
	void createFeedbackWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).saveFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.createFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedback("feedbackDetails1");
		});
	}

	// Sapient generated method id: ${99dfc40e-47da-30a2-8878-ba865801382d}, hash:
	// B5524E5949AFA45D3809AF8B0251CDC4
	@Test()
	void feedbacksListTest() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbacksList("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	// Sapient generated method id: ${6c680802-b2da-3262-8d0c-39282d997ab2}, hash:
	// 1B016CF2E991E6411C45291B452BD6C0
	@Test()
	void feedbacksListWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbacksList("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	// Sapient generated method id: ${600906f2-1c94-3c04-bf28-8fc0b0af9877}, hash:
	// B938970D9731958188DAB47274446037
	@Test()
	void getFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getAllData("feedbackRequest1");
		// Act Statement(s)
		String result = target.getFeedback("feedbackRequest1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getAllData("feedbackRequest1");
		});
	}

	// Sapient generated method id: ${03b03c74-4bdb-39b4-95b1-ab594001da13}, hash:
	// 9081989727E138775EFAAEED857E2855
	@Test()
	void getFeedbackWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getAllData("feedbackRequest1");
		// Act Statement(s)
		String result = target.getFeedback("feedbackRequest1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getAllData("feedbackRequest1");
		});
	}

	// Sapient generated method id: ${1325eb4f-b5ec-30c1-9b5e-2f41a9228153}, hash:
	// 3A0E805A7DD9C32228AC3D26A60398F8
	@Test()
	void updateFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn(2).when(feedbackServiceMock).updateFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.updateFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"2\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedback("feedbackDetails1");
		});
	}

	// Sapient generated method id: ${40a625bb-67f7-3923-b45c-20f6136a66ec}, hash:
	// 4B6D0896D35F84B17FB2D958F264374B
	@Test()
	void updateFeedbackWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn(2).when(feedbackServiceMock).updateFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.updateFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"2\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedback("feedbackDetails1");
		});
	}

	// Sapient generated method id: ${ddf115f1-3249-323f-9035-b67e88bcd44e}, hash:
	// 1874C09610D0BB478D42ACEE7E8F4424
	@Test()
	void updateFeedbackStatusTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateFeedbackStatus("");
		// Act Statement(s)
		String result = target.updateFeedbackStatus("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedbackStatus("");
		});
	}

	// Sapient generated method id: ${84c767ae-57bb-347f-983e-87c7500e1fbf}, hash:
	// 8BF3A16D646734A638542D471FEFBF74
	@Test()
	void updateFeedbackStatusWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateFeedbackStatus("D");
		// Act Statement(s)
		String result = target.updateFeedbackStatus("D");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedbackStatus("D");
		});
	}

	// Sapient generated method id: ${3dd17631-6042-371e-ba2c-06eb0ab37da8}, hash:
	// 34A12C19877B9F6AABE7B97F3D89D5C5
	@Test()
	void searchFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback("");
		// Act Statement(s)
		String result = target.searchFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback("");
		});
	}

	// Sapient generated method id: ${106435fd-347d-376a-8c68-2a07f76fca19}, hash:
	// 5C0B3E8CD23A4655B0F834E08A2372FF
	@Test()
	void searchFeedbackWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback("");
		// Act Statement(s)
		String result = target.searchFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback("");
		});
	}

	// Sapient generated method id: ${ebd68aff-b454-316c-99a6-1312316bf40b}, hash:
	// 874B94FA65301A91F8523DBDE2D0C9F1
	@Test()
	void searchFeedback1Test() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback1("");
		// Act Statement(s)
		String result = target.searchFeedback1("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback1("");
		});
	}

	// Sapient generated method id: ${312b36cd-f2c5-34d8-b22e-97ae92b11bde}, hash:
	// 6E9C0FCFB2776DE25B1AACBEC73CC54A
	@Test()
	void searchFeedback1WhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback1("");
		// Act Statement(s)
		String result = target.searchFeedback1("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback1("");
		});
	}

	// Sapient generated method id: ${3f75b0c9-fb22-3eb1-99e3-60486a4cd3f5}, hash:
	// 54ACB08D66C312D48558D8C94DF80934
	@Test()
	void getAllFeedbackByIdTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getAllFeedbackById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	// Sapient generated method id: ${5330197e-bdd2-3d71-a59c-e957711e9cbc}, hash:
	// EB8C6EBC7EDC6EC2F18E56B21706C36D
	@Test()
	void getAllFeedbackByIdWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getAllFeedbackById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	// Sapient generated method id: ${2be9fed3-10dc-39c2-a089-b7152fb2aba5}, hash:
	// B813ADB01FC09B080073B2A6DF64E8C3
	
//	@Test()
//	void getAllfeedbackWhenData2IsNotEmpty() {
//		/*
//		 * Branches:* (data2 != null) : true* (data2.size() > 0) : true*
//		 * (for-each(data2)) : true
//		 */
//		// Arrange Statement(s)
//		try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class)) {
//			Gson gson = new Gson();
//			outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//			target = new FeedbackController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			Object object = new Object();
//			Object object2 = new Object();
//			Object object3 = new Object();
//			Object object4 = new Object();
//			Object object5 = new Object();
//			Object object6 = new Object();
//			Object object7 = new Object();
//			Object object8 = new Object();
//			Object object9 = new Object();
//			Object[] objectArray = new Object[] { object, object2, object3, object4, object5, object6, object7, object8,
//					object9 };
//			ArrayList<Object[]> objectList = new ArrayList<>();
//			objectList.add(objectArray);
//			doReturn(objectList).when(feedbackResponseServiceMock).getdataById(0L);
//			FeedbackResponse feedbackResponse = new FeedbackResponse();
//			feedbackResponse.setFeedbackID(0L);
//			// Act Statement(s)
//			String result = target.getAllfeedback(feedbackResponse);
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo("result1"));
//				outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//				verify(feedbackResponseServiceMock).getdataById(0L);
//			});
//		}
//	}

	// Sapient generated method id: ${b55f32b0-6608-3b68-9b57-67d5998a0e5f}, hash:
	// C3E626822CB5A1BE9415B1569B6BA882
	@Test()
	void getFeedbackStatusTypesTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getFeedbackStatus("request1");
		// Act Statement(s)
		String result = target.getFeedbackStatusTypes("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackStatus("request1");
		});
	}

	// Sapient generated method id: ${10c23ab1-fb82-3597-9de6-2f93db0c3de4}, hash:
	// 5AF7F0DE664008B140EBA8CEC974E6F5
	@Test()
	void getFeedbackStatusTypesWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getFeedbackStatus("request1");
		// Act Statement(s)
		String result = target.getFeedbackStatusTypes("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackStatus("request1");
		});
	}

	// Sapient generated method id: ${a7b12b05-9850-3112-89ba-1b0f7c0ea602}, hash:
	// 67E8F07445B4C60FD3598A903D3E1154
	@Test()
	void getEmailStatusTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getEmailStatus("request1");
		// Act Statement(s)
		String result = target.getEmailStatus("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getEmailStatus("request1");
		});
	}

	// Sapient generated method id: ${4691cac1-6e49-3056-be6a-53956fac6ad5}, hash:
	// 4369F8F42720C88958EC15232AEF97ED
	@Test()
	void getEmailStatusWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getEmailStatus("request1");
		// Act Statement(s)
		String result = target.getEmailStatus("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getEmailStatus("request1");
		});
	}

	// Sapient generated method id: ${92b8e803-16c7-3d11-8fb9-630034ce795b}, hash:
	// A55733666E880DCDD8D9F5E1220F19BD
	@Test()
	void getFeedbackRequestByIdTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackRequestById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	// Sapient generated method id: ${4b33701b-0cee-35ba-a541-4fc6f269e41c}, hash:
	// 5411A2F2DFAC3B41645A55BB66F5A23D
	@Test()
	void getFeedbackRequestByIdWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackRequestById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	// Sapient generated method id: ${765401f5-e802-3c42-9d23-8371268ad5a2}, hash:
	// A26611AC8C9394189DC1F857DF1195E5
	@Test()
	void getFeedbackResponseByIdTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackResponseById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	// Sapient generated method id: ${ede2d3ee-e53a-3a72-81c4-86d279a8eb27}, hash:
	// 37E86F6B6C77167702F388797A98B855
	@Test()
	void getFeedbackResponseByIdWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackResponseById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	// Sapient generated method id: ${7ab15ef3-dc53-3175-9ffc-c0b59f481610}, hash:
	// 4E5705C96D8AE4BF46A01EC90A542F9F
	@Test()
	void getFeedbacksListTest() throws Exception {
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getFeedbacksList_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		// Act Statement(s)
		String result = target.getFeedbacksList(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${debbd827-1458-329c-9570-c19c9597d8f6}, hash:
	// F7E20226CE0E9E162E771DA298FACE78
	@Test()
	void getFeedbacksListWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getFeedbacksList_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		// Act Statement(s)
		String result = target.getFeedbacksList(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${232ad242-1a8f-3a07-8d0c-8cb40b80682b}, hash:
	// 399BA58F5C0EDF095B4EBB56F58B0B42
	@Test()
	void updateResponseTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateResponse("");
		// Act Statement(s)
		String result = target.updateResponse("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateResponse("");
		});
	}

	// Sapient generated method id: ${c617a530-07df-34e4-a8bf-9ad8b8075c87}, hash:
	// E5B06485B7A4285BCB32794BAC69378D
	@Test()
	void updateResponseWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateResponse("");
		// Act Statement(s)
		String result = target.updateResponse("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateResponse("");
		});
	}

	// Sapient generated method id: ${8cf86177-2960-3ee0-9be1-9dc3529990d7}, hash:
	// 7928D3E26A8757FC52D390C1CB7C9660
	@Test()
	void requestFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).createFeedbackRequest("");
		// Act Statement(s)
		String result = target.requestFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).createFeedbackRequest("");
		});
	}

	// Sapient generated method id: ${550e6c50-8e1e-315d-a622-82d2e3fa5d63}, hash:
	// 43DEBA16E2613F7A40D08D96AEBC10C9
	@Test()
	void requestFeedbackWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).createFeedbackRequest("");
		// Act Statement(s)
		String result = target.requestFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).createFeedbackRequest("");
		});
	}

	// Sapient generated method id: ${010401b7-07f2-35e1-b6c7-1b27fbb86122}, hash:
	// E476538CF55F5F994EC3944F5B8647D2
//	@Test()
//	void getFeedbackSeverityTest() throws Exception {
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		FeedbackSeverity feedbackSeverityMock = mock(FeedbackSeverity.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(feedbackSeverityMock).when(inputMapperMock).fromJson("severityRequest1", FeedbackSeverity.class);
//			doReturn(0).when(feedbackSeverityMock).getProviderServiceMapID();
//			target = new FeedbackController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			List<FeedbackSeverity> feedbackSeverityList = new ArrayList<>();
//			doReturn(feedbackSeverityList).when(feedbackSeverityServiceMock).getActiveFeedbackSeverity(0);
//			// Act Statement(s)
//			String result = target.getFeedbackSeverity("severityRequest1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("severityRequest1", FeedbackSeverity.class);
//				verify(feedbackSeverityMock).getProviderServiceMapID();
//				verify(feedbackSeverityServiceMock).getActiveFeedbackSeverity(0);
//			});
//		}
//	}

//	// Sapient generated method id: ${2009285d-73e4-35c1-9390-298cfd488589}, hash:
//	// 6300873B0DAEE90E6266021DC7BB1B2C
//	@Test()
//	void getFeedbackSeverityWhenCaughtException() throws Exception {
//		/*
//		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
//		 * method is not unit testable!* Following variables could not be
//		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
//		 * arguments or create a setter for them (avoid new operator)* or adjust the
//		 * input/test parameter values manually to satisfy the requirements of the given
//		 * test scenario.* The test code, including the assertion statements, has been
//		 * successfully generated.
//		 */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		FeedbackSeverity feedbackSeverityMock = mock(FeedbackSeverity.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(feedbackSeverityMock).when(inputMapperMock).fromJson("severityRequest1", FeedbackSeverity.class);
//			doReturn(0).when(feedbackSeverityMock).getProviderServiceMapID();
//			target = new FeedbackController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			List<FeedbackSeverity> feedbackSeverityList = new ArrayList<>();
//			doReturn(feedbackSeverityList).when(feedbackSeverityServiceMock).getActiveFeedbackSeverity(0);
//			// Act Statement(s)
//			String result = target.getFeedbackSeverity("severityRequest1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("severityRequest1", FeedbackSeverity.class);
//				verify(feedbackSeverityMock).getProviderServiceMapID();
//				verify(feedbackSeverityServiceMock).getActiveFeedbackSeverity(0);
//			});
//		}
//	}

	// Sapient generated method id: ${89016c52-e01a-3b5b-92af-5bf2fae3d38d}, hash:
	// D53C708AD8D9FA190AEBF86306ACCE61
//	@Test()
//	void getFeedbackTypeTest() throws Exception {
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		FeedbackType feedbackTypeMock = mock(FeedbackType.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(feedbackTypeMock).when(inputMapperMock).fromJson("severityRequest1", FeedbackType.class);
//			doReturn(0).when(feedbackTypeMock).getProviderServiceMapID();
//			target = new FeedbackController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			List<FeedbackType> feedbackTypeList = new ArrayList<>();
//			doReturn(feedbackTypeList).when(feedbackTypeServiceMock).getActiveFeedbackTypes(0);
//			// Act Statement(s)
//			String result = target.getFeedbackType("severityRequest1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("severityRequest1", FeedbackType.class);
//				verify(feedbackTypeMock).getProviderServiceMapID();
//				verify(feedbackTypeServiceMock).getActiveFeedbackTypes(0);
//			});
//		}
//	}

	// Sapient generated method id: ${5638aafc-563d-37f2-b0fa-674ca26656ac}, hash:
	// D110398ADBCC8485DB587C19AACE2377
//	@Test()
//	void getFeedbackTypeWhenCaughtException() throws Exception {
//		/*
//		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
//		 * method is not unit testable!* Following variables could not be
//		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
//		 * arguments or create a setter for them (avoid new operator)* or adjust the
//		 * input/test parameter values manually to satisfy the requirements of the given
//		 * test scenario.* The test code, including the assertion statements, has been
//		 * successfully generated.
//		 */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		FeedbackType feedbackTypeMock = mock(FeedbackType.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(feedbackTypeMock).when(inputMapperMock).fromJson("severityRequest1", FeedbackType.class);
//			doReturn(0).when(feedbackTypeMock).getProviderServiceMapID();
//			target = new FeedbackController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			List<FeedbackType> feedbackTypeList = new ArrayList<>();
//			doReturn(feedbackTypeList).when(feedbackTypeServiceMock).getActiveFeedbackTypes(0);
//			// Act Statement(s)
//			String result = target.getFeedbackType("severityRequest1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("severityRequest1", FeedbackType.class);
//				verify(feedbackTypeMock).getProviderServiceMapID();
//				verify(feedbackTypeServiceMock).getActiveFeedbackTypes(0);
//			});
//		}
//	}

	// Sapient generated method id: ${e50e19c9-ef1c-3c2b-a01c-f370d9ecbb7a}, hash:
	// DADDB788C0C41945A6420288FC71A50B
	@Test()
	void getGrievancesByCreatedDateTest() throws Exception {
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByCreatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByCreatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${18b97990-90b1-3d8d-a4c1-cef12be9bc57}, hash:
	// 3E15DAA476EEF73A0289776E75544FD7
	@Test()
	void getGrievancesByCreatedDateWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByCreatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByCreatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${eafbf95c-ff4f-3081-897b-fc80540e62a5}, hash:
	// E4B3306C1EA6B4CEFE0FA407E9BA780D
	@Test()
	void getGrievancesByUpdatedDateTest() throws Exception {
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByUpdatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByUpdatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${4fb8220a-ef79-3ab4-85c6-be5d27793fc2}, hash:
	// 947A8D6C2D37A1E4B7255694C6F6B87C
	@Test()
	void getGrievancesByUpdatedDateWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByUpdatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByUpdatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${9f527abd-8937-394a-8b33-cff4018923b7}, hash:
	// A5EAFAE77C1EF099AC4E4AEDD101C48D
	@Test()
	void createFeedbackRequestTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).saveFeedbackRequest("A");
		// Act Statement(s)
		String result = target.createFeedbackRequest("A");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedbackRequest("A");
		});
	}

	// Sapient generated method id: ${77109a03-8c5d-3c5c-af0f-e58e4d92e49f}, hash:
	// 902292C6A50AF039C7A8EEA44848B97C
	@Test()
	void createFeedbackRequestWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).saveFeedbackRequest("D");
		// Act Statement(s)
		String result = target.createFeedbackRequest("D");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedbackRequest("D");
		});
	}

	// Sapient generated method id: ${c9d5ac21-608d-30f4-899f-f1355e12cedf}, hash:
	// BD0FE36B388F2DEE2D4A167744A39D09
	@Test()
	void getFeedbackLogsTest() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackLog feedbackLogMock = mock(FeedbackLog.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackLogMock).when(inputMapperMock).fromJson("A", FeedbackLog.class);
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			doReturn("B").when(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			// Act Statement(s)
			String result = target.getFeedbackLogs("A");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("A", FeedbackLog.class);
				verify(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			});
		}
	}

	// Sapient generated method id: ${9416f9c6-8a72-3286-a833-0418f3eb10ae}, hash:
	// 30AD9055C0AA0776354B59B84558D02E
	@Test()
	void getFeedbackLogsWhenCaughtException() throws Exception {

		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackLog feedbackLogMock = mock(FeedbackLog.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackLogMock).when(inputMapperMock).fromJson("D", FeedbackLog.class);
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			doReturn("B").when(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			// Act Statement(s)
			String result = target.getFeedbackLogs("D");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("D", FeedbackLog.class);
				verify(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			});
		}
	}

	@Test()
	void feedbackRequestExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackRequests(any())).thenThrow(NotFoundException.class);

		String response = target.feedbackRequest(request);
		assertEquals(response, target.feedbackRequest(request));
	}

	@Test()
	 void getFeedbackByPostExpTest() {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackRequests(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedback(request);
		assertEquals(response, target.getFeedback(request));
	}

	@Test()
	 void createFeedbackExpTest() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.saveFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.createFeedback(request);
		assertEquals(response, target.createFeedback(request));
	}

	@Test()
	 void feedbacksListExpTest() {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackRequests(any())).thenThrow(NotFoundException.class);

		String response = target.feedbacksList(request);
		assertEquals(response, target.feedbacksList(request));
	}

	@Test()
	 void updateFeedbackExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.updateFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.updateFeedback(request);
		assertEquals(response, target.updateFeedback(request));
	}

	@Test()
	 void updateFeedbackStatusExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.updateFeedbackStatus(any())).thenThrow(NotFoundException.class);

		String response = target.updateFeedbackStatus(request);
		assertEquals(response, target.updateFeedbackStatus(request));
	}

	@Test()
	 void searchFeedbackExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.searchFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.searchFeedback(request);
		assertEquals(response, target.searchFeedback(request));
	}

	@Test()
	 void searchFeedback1ExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.searchFeedback1(any())).thenThrow(NotFoundException.class);

		String response = target.searchFeedback1(request);
		assertEquals(response, target.searchFeedback1(request));
	}

	@Test()
	 void getAllFeedbackByIdExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackRequestServiceMock.getAllFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.getAllFeedbackById(request);
		assertEquals(response, target.getAllFeedbackById(request));
	}

	@Test()
	 void getFeedbackStatusTypesExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackStatus(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackStatusTypes(request);
		assertEquals(response, target.getFeedbackStatusTypes(request));
	}

	@Test()
	 void getEmailStatusExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getEmailStatus(any())).thenThrow(NotFoundException.class);

		String response = target.getEmailStatus(request);
		assertEquals(response, target.getEmailStatus(request));
	}

	@Test()
	 void getFeedbackRequestByIdExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackRequestServiceMock.getAllFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackRequestById(request);
		assertTrue(response.contains("Failed with null"));
		// assertEquals(response, target.getFeedbackRequestById(request));
	}

	@Test()
	 void getFeedbackResponseByIdExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackRequestServiceMock.getAllFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackResponseById(request);
		assertEquals(response, target.getFeedbackResponseById(request));
	}

	@Test()
	 void getFeedbacksListExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbacksList(any(), any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbacksList(any(), any());
		assertEquals(response, target.getFeedbacksList(any(), any()));
	}

	@Test()
	 void updateResponseExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.updateResponse(any())).thenThrow(NotFoundException.class);

		String response = target.updateResponse(any());
		assertEquals(response, target.updateResponse(any()));
	}

	@Test()
	 void requestFeedbackExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.createFeedbackRequest(any())).thenThrow(NotFoundException.class);

		String response = target.requestFeedback(any());
		assertTrue(response.contains("Failed with null"));
//		assertEquals(response, target.requestFeedback(any()));
	}

	@Test()
	 void getFeedbackSeverityExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackSeverityServiceMock.getActiveFeedbackSeverity(any()).toString())
				.thenThrow(NotFoundException.class);

		String response = target.getFeedbackSeverity(any());
		assertEquals(response, target.getFeedbackSeverity(any()));
	}

	@Test()
	 void getFeedbackTypeExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackTypeServiceMock.getActiveFeedbackTypes(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackType(any());
		assertEquals(response, target.getFeedbackType(any()));
	}

	@Test()
	 void getGrievancesByCreatedDateExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getGrievancesByCreatedDate(any(), any())).thenThrow(NotFoundException.class);

		String response = target.getGrievancesByCreatedDate(any(), any());
		assertEquals(response, target.getGrievancesByCreatedDate(any(), any()));
	}

	@Test()
	 void getGrievancesByUpdatedDateExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getGrievancesByUpdatedDate(any(), any())).thenThrow(NotFoundException.class);

		String response = target.getGrievancesByUpdatedDate(any(), any());
		
		assertTrue(response.contains("error"));
		//assertEquals(response, target.getGrievancesByUpdatedDate(any(), any()));
	}

	@Test()
	 void createFeedbackRequestExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.saveFeedbackRequest(any())).thenThrow(NotFoundException.class);

		String response = target.createFeedbackRequest(any());
		assertEquals(response, target.createFeedbackRequest(any()));
	}

	@Test()
	 void getFeedbackLogsExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.saveFeedbackRequest(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackLogs(any());
		assertEquals(response, target.getFeedbackLogs(any()));
	}

	@Test
	void testGetAllFeedbackReturnsCorrectJson() {
		// Given
		FeedbackResponse mockFeedbackResponse = new FeedbackResponse();
		mockFeedbackResponse.setFeedbackID(1L);
		ArrayList<Object[]> mockedData = new ArrayList<>();
		mockedData.add(new Object[] { "Summary", 101, "Good", "John Doe", "Manager", 1, "SupSummary", null,
				"Detailed Feedback" });

		when(feedbackResponseServiceMock.getdataById(1L)).thenReturn(mockedData);

		// When
		String result = target.getAllfeedback(mockFeedbackResponse);

		// Expected JSON
		List<Map<String, Object>> expectedResList = new ArrayList<>();
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("ResponseSummary", "Summary");
		resMap.put("FeedbackRequestID", 101);
		resMap.put("Comments", "Good");
		resMap.put("AuthName", "John Doe");
		resMap.put("AuthDesignation", "Manager");
		resMap.put("FeedbackID", 1);
		resMap.put("FeedbackSupSummary", "SupSummary");
		resMap.put("Feedback", "Detailed Feedback");
		expectedResList.add(resMap);

		Gson gson = new GsonBuilder().create();
		String expectedJson = gson.toJson(expectedResList);

		// Then
		assertEquals(expectedJson, result);

		// Verify
		verify(feedbackResponseServiceMock, times(1)).getdataById(1L);
	}

	@Test
	void testGetFeedbackByPostExceptionPath() {
		Long feedbackID = 1L;

		// Simulate an exception when feedbackService.getFeedbackRequests is called
		when(feedbackServiceMock.getFeedbackRequests(anyLong())).thenThrow(new RuntimeException("Test Exception"));

		// Execute the method that you're testing
		String result = target.getFeedbackByPost(feedbackID);

		// Assert on the response
		assertTrue(result.contains("error")); // Adjust this assertion based on how your OutputResponse.toString() is
	}

}
