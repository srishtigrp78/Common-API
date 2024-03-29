//package com.iemr.common.controller.carestream;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class CareStreamCreateOrderControllerTest2 {
//
//    private CareStreamCreateOrderController careStreamCreateOrderControllerUnderTest;
//
//    @BeforeEach
//    void setUp() {
//        careStreamCreateOrderControllerUnderTest = new CareStreamCreateOrderController();
//        ReflectionTestUtils.setField(careStreamCreateOrderControllerUnderTest, "carestreamSocketIP", "192.168.1.101");
//        ReflectionTestUtils.setField(careStreamCreateOrderControllerUnderTest, "carestreamSocketPort", 0);
//    }
//
//    @Test
//    void testCreateOrder() throws Exception {
//        // Setup
//        // Run the test
//        final String result = careStreamCreateOrderControllerUnderTest.createOrder("createOrder");
//
//        // Verify the results
//        assertEquals("Success", result);
//    }
//
//    @Test
//    void testCreateOrder_ThrowsUnknownHostException() {
//        // Setup
//        // Run the test
//        assertThrows(UnknownHostException.class,
//                () -> careStreamCreateOrderControllerUnderTest.createOrder("createOrder"));
//    }
//
//    @Test
//    void testCreateOrder_ThrowsIOException() {
//        // Setup
//        // Run the test
//        assertThrows(IOException.class, () -> careStreamCreateOrderControllerUnderTest.createOrder("createOrder"));
//    }
//
//    @Test
//    void testUpdateOrder() throws Exception {
//        // Setup
//        // Run the test
//        final String result = careStreamCreateOrderControllerUnderTest.updateOrder("UpdateOrder");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateOrder_ThrowsUnknownHostException() {
//        // Setup
//        // Run the test
//        assertThrows(UnknownHostException.class,
//                () -> careStreamCreateOrderControllerUnderTest.updateOrder("UpdateOrder"));
//    }
//
//    @Test
//    void testUpdateOrder_ThrowsIOException() {
//        // Setup
//        // Run the test
//        assertThrows(IOException.class, () -> careStreamCreateOrderControllerUnderTest.updateOrder("UpdateOrder"));
//    }
//
//    @Test
//    void testDeleteOrder() throws Exception {
//        // Setup
//        // Run the test
//        final String result = careStreamCreateOrderControllerUnderTest.deleteOrder("deleteOrder");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testDeleteOrder_ThrowsUnknownHostException() {
//        // Setup
//        // Run the test
//        assertThrows(UnknownHostException.class,
//                () -> careStreamCreateOrderControllerUnderTest.deleteOrder("deleteOrder"));
//    }
//
//    @Test
//    void testDeleteOrder_ThrowsIOException() {
//        // Setup
//        // Run the test
//        assertThrows(IOException.class, () -> careStreamCreateOrderControllerUnderTest.deleteOrder("deleteOrder"));
//    }
//}
