//package com.iemr.common.controller.secondaryReport;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//import java.sql.Timestamp;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.ResponseEntity;
//
//import com.iemr.common.data.report.CallQualityReport;
//import com.iemr.common.service.reportSecondary.SecondaryReportService;
//import com.iemr.common.utils.mapper.InputMapper;
//
//@ExtendWith(MockitoExtension.class)
//public class CustomerRelationshipSecondaryReportsTest {
//    
//    @Mock
//    private InputMapper inputMapper;
//    
//    @Mock
//    private SecondaryReportService secondaryReportService;
//    
//    @InjectMocks
//    private CustomerRelationshipSecondaryReports customerRelationshipSecondaryReports;
//    
//    @Test
//    public void getQualityReportTest() {
//        String jsonRequest = "{\n"
//                + "  \"startDate\": \"2022-01-01 00:00:00\",\n"
//                + "  \"endDate\": \"2022-01-31 23:59:59\",\n"
//                + "  \"providerServiceMapID\": 1,\n"
//                + "  \"agentID\": 1,\n"
//                + "  \"roleName\": \"Agent\",\n"
//                + "  \"reportTypeID\": 1,\n"
//                + "  \"reportType\": \"Quality\"\n"
//                + "}";
//        
//        CallQualityReport callQualityReport = new CallQualityReport();
//        callQualityReport.setStartDate(Timestamp.valueOf("2022-01-01 00:00:00"));
//        callQualityReport.setEndDate(Timestamp.valueOf("2022-01-31 23:59:59"));
//        callQualityReport.setProviderServiceMapID(1);
//        callQualityReport.setRoleID(1L);
//        callQualityReport.setReceivedRoleName("Agent");
//        callQualityReport.setCallTypeID(1);
//        callQualityReport.setCallType("Quality");
//        
//        when(inputMapper.fromJson(jsonRequest, CallQualityReport.class)).thenReturn(callQualityReport);
////                new InputStreamResource(getClass().getClassLoader().getResourceAsStream("test.xlsx")));
//        
//        ResponseEntity<Object> response = customerRelationshipSecondaryReports.getQualityReport(jsonRequest);
//        
//        assertNotNull(response);
//        assertEquals(200, response.getStatusCodeValue());
//    }
//    
//    @Test
//    public void getComplaintDetailReportTest() {
//        String jsonRequest = "{\n"
//                + "  \"startDate\": \"2022-01-01 00:00:00\",\n"
//                + "  \"endDate\": \"2022-01-31 23:59:59\",\n"
//                + "  \"providerServiceMapID\": 1,\n"
//                + "  \"agentID\": 1,\n"
//                + "  \"roleName\": \"Agent\",\n"
//                + "  \"reportTypeID\": 1,\n"
//                + "  \"reportType\": \"Quality\"\n"
//                + "}";
//        
//     //   when(secondaryReportService.getComplaintDetailReport(jsonRequest, "Grievance_Details")).thenReturn(
//      //          new InputStreamResource(getClass().getClassLoader().getResourceAsStream("test.xlsx")));
//        
//        ResponseEntity<Object> response = customerRelationshipSecondaryReports.getComplaintDetailReport(jsonRequest);
//        
//        assertNotNull(response);
//        assertEquals(200, response.getStatusCodeValue());
//    }
//    
//}