package com.iemr.common.service.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.repository.category.CategoryRepository;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryServiceImpl categoryService;

//    @Test
//    void testGetAllCategoriesWithFeedbackNatureID() throws Exception {
//        // Initialize request string directly
//        String requestWithFeedbackNatureID = "{\"feedbackNatureID\":1, \"providerServiceMapID\":2}";
//
//        List<CategoryDetails> expected = new ArrayList<>();
//        expected.add(new CategoryDetails(1, "Category 1"));
//        when(categoryRepository.getCategoriesByNatureID(anyInt(), anyInt())).thenReturn((ArrayList<CategoryDetails>) expected);
//
//        // When
//        List<CategoryDetails> result = categoryService.getAllCategories(requestWithFeedbackNatureID);
//
//        // Then
//        verify(categoryRepository, times(1)).getCategoriesByNatureID(anyInt(), anyInt());
//        assertFalse(result.isEmpty());
//        assertEquals(1, result.size());
//        assertEquals("Category 1", result.get(0).getCategoryName());
//    }
//
//    @Test
//    void testGetAllCategoriesWithIsWellBeing() throws Exception {
//        // Initialize request string directly
//        String requestWithIsWellBeing = "{\"isWellBeing\":true, \"subServiceID\":3}";
//
//        List<CategoryDetails> expected = new ArrayList<>();
//        expected.add(new CategoryDetails(2, "WellBeing Category"));
//        when(categoryRepository.getAllCategories(anyInt(), anyBoolean())).thenReturn((ArrayList<CategoryDetails>) expected);
//
//        // When
//        List<CategoryDetails> result = categoryService.getAllCategories(requestWithIsWellBeing);
//
//        // Then
//        verify(categoryRepository, times(1)).getAllCategories(anyInt(), anyBoolean());
//        assertFalse(result.isEmpty());
//        assertEquals("WellBeing Category", result.get(0).getCategoryName());
//    }
//
//    @Test
//    void testGetAllCategoriesDefault() throws Exception {
//        // Initialize request string directly
//        String requestDefault = "{\"subServiceID\":4}";
//
//        List<CategoryDetails> expected = new ArrayList<>();
//        expected.add(new CategoryDetails(3, "Default Category"));
//        when(categoryRepository.getAllCategories(anyInt())).thenReturn((ArrayList<CategoryDetails>) expected);
//
//        // When
//        List<CategoryDetails> result = categoryService.getAllCategories(requestDefault);
//
//        // Then
//        verify(categoryRepository, times(1)).getAllCategories(anyInt());
//        assertFalse(result.isEmpty());
//        assertEquals("Default Category", result.get(0).getCategoryName());
//    }

	@Test
	void testGetAllCategoriesReturnsCorrectData() {
		// Setup
		List<CategoryDetails> expectedCategories = new ArrayList<>();
		expectedCategories.add(new CategoryDetails(1, "Health"));
		expectedCategories.add(new CategoryDetails(2, "Wellness"));

		when(categoryRepository.findBy()).thenReturn((ArrayList<CategoryDetails>) expectedCategories);

		// Execution
		List<CategoryDetails> result = categoryService.getAllCategories();

		// Assertions
		assertNotNull(result, "The result should not be null.");
		assertEquals(expectedCategories.size(), result.size(),
				"The size of the results should match the expected size.");
		assertEquals(expectedCategories.get(0).getCategoryID(), result.get(0).getCategoryID(),
				"The first category ID should match.");
		assertEquals(expectedCategories.get(0).getCategoryName(), result.get(0).getCategoryName(),
				"The first category name should match.");
		assertEquals(expectedCategories.get(1).getCategoryID(), result.get(1).getCategoryID(),
				"The second category ID should match.");
		assertEquals(expectedCategories.get(1).getCategoryName(), result.get(1).getCategoryName(),
				"The second category name should match.");

		// Verification
		verify(categoryRepository, times(1)).findBy();
	}
}
