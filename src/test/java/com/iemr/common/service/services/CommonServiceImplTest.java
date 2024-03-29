package com.iemr.common.service.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.data.category.SubCategoryDetails;
import com.iemr.common.repository.category.CategoryRepository;
import com.iemr.common.repository.category.SubCategoryRepository;
import com.iemr.common.repository.kmfilemanager.KMFileManagerRepository;
import com.iemr.common.repository.services.ServiceTypeRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@ExtendWith(MockitoExtension.class)
class CommonServiceImplTest {

	@InjectMocks
	CommonServiceImpl commonService;

	@Mock
	private ServiceTypeRepository serviceTypeRepository;
	@Mock
	private CategoryRepository categoryRepository;
	@Mock
	private SubCategoryRepository subCategoryRepository;
	@Mock
	private KMFileManagerRepository kmFileManagerRepository;
	@Mock
	private InputMapper inputMapper = new InputMapper();

//	@Test
//	void testSetCategoryRepository() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetSubCategoryRepository() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetServiceTypeRepository() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetKmFileManagerRepository() {
//		fail("Not yet implemented");
//	}

//	
//	@Test
//	void testGetCategories() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCategoriesReturnsData() {
		// Local setup for this test case
		List<CategoryDetails> localMockCategories = new ArrayList<>();
		localMockCategories.add(new CategoryDetails(1, "Category 1"));
		localMockCategories.add(new CategoryDetails(2, "Category 2"));

		// Setup our mock repository
		when(categoryRepository.findBy()).thenReturn((ArrayList<CategoryDetails>) localMockCategories);

		// Execute the service call
		Iterable<CategoryDetails> categories = commonService.getCategories();

		// Assert the response
		List<CategoryDetails> resultList = new ArrayList<>();
		categories.forEach(resultList::add);
		assertEquals(2, resultList.size());
		assertEquals(localMockCategories, resultList);
	}

	@Test
	void testGetCategoriesReturnsEmptyList() {
		// Local setup for this test case with an empty list
		List<CategoryDetails> localEmptyList = new ArrayList<>();

		// Setup our mock repository to return an empty list
		when(categoryRepository.findBy()).thenReturn((ArrayList<CategoryDetails>) localEmptyList);

		// Execute the service call
		Iterable<CategoryDetails> categories = commonService.getCategories();

		// Assert the response
		List<CategoryDetails> resultList = new ArrayList<>();
		categories.forEach(resultList::add);
		assertEquals(0, resultList.size());
	}

//	@Test
//	void testGetSubCategories() {
//		fail("Not yet implemented");
//	}
	
//	@Test
//    void testGetSubCategories() {
//        // Arrange
//        String request = "{\"categoryID\":\"123\"}";
//        SubCategoryDetails subCategoryDetails = new SubCategoryDetails();
//        subCategoryDetails.setCategoryID(123);
//
//        List<Object[]> lists = new ArrayList<>();
//        Object[] objects1 = new Object[3];
//        objects1[0] = 1;
//        objects1[1] = "SubCat1";
//        objects1[2] = "path/to/file1";
//        lists.add(objects1);
//
//        Object[] objects2 = new Object[3];
//        objects2[0] = 2;
//        objects2[1] = "SubCat2";
//        objects2[2] = null;
//        lists.add(objects2);
//
//        List<Object[]> fileNameList = new ArrayList<>();
//        Object[] fileNameObjects = new Object[2];
//        fileNameObjects[0] = "fileName1";
//        fileNameObjects[1] = ".ext1";
//        fileNameList.add(fileNameObjects);
//
//        given(inputMapper.gson()).willReturn(inputMapper);
//        given(inputMapper.fromJson(request, SubCategoryDetails.class)).willReturn(subCategoryDetails);
//        given(subCategoryRepository.findByCategoryID(subCategoryDetails.getCategoryID())).willReturn((ArrayList<Object[]>) lists);
////        given(commonService.getFilePath(objects1[2])).willReturn("UIDAsURI1");
////        given(kmFileManagerRepository.getFileNameByUID(objects1[2])).willReturn(fileNameList);
//
//        // Act
//        Iterable<SubCategoryDetails> result = commonService.getSubCategories(request);
//        List<SubCategoryDetails> subCategories = new ArrayList<>();
//        result.forEach(subCategories::add);
//
//        // Assert
//        assertEquals(2, subCategories.size());
//        assertEquals("SubCat1", subCategories.get(0).getSubCategoryName());
//      //  assertEquals("UIDAsURI1", subCategories.get(0).getFileUIDAsURI());
//        assertEquals("fileName1.ext1", subCategories.get(0).getFileNameWithExtension());
//	}
	
//	@Test
//	void testGetSubCategoriesReturnsData() throws IEMRException {
//		// Inline setup for this test
//		String request = "{\"categoryID\":1}"; // Example request
//
//		// Mocking the repository response directly within the test method
//		ArrayList<Object[]> mockResponse = new ArrayList<>();
//		mockResponse.add(new Object[] { 1, "SubCategory 1", null }); // Simplified for demonstration
//		mockResponse.add(new Object[] { 2, "SubCategory 2", null }); // Assuming no file path for simplicity
//
//		when(subCategoryRepository.findByCategoryID(anyInt())).thenReturn(mockResponse);
//
//		// Call the method under test
//		Iterable<SubCategoryDetails> result = commonService.getSubCategories(request);
//
//		// Convert the result to a list for easier assertion
//		List<SubCategoryDetails> resultList = new ArrayList<>();
//		result.forEach(resultList::add);
//
//		// Assertions
//		assertEquals(2, resultList.size(), "Expected two subcategories in the result");
//		assertEquals(1, resultList.get(0).getSubCategoryID());
//		assertEquals("SubCategory 1", resultList.get(0).getSubCategoryName());
//		assertEquals(2, resultList.get(1).getSubCategoryID());
//		assertEquals("SubCategory 2", resultList.get(1).getSubCategoryName());
//
//		// Verify repository interaction with the specific category ID
//		verify(subCategoryRepository).findByCategoryID(1);
//	}

//	
//	@Test
//	void testGetSubCategoryFiles() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetSubCategoryFiles() throws IEMRException {
//		// Example input JSON
//		String request = "{\"subCategoryID\":1}";
//
//		// Mock the subCategoryRepository response
//		List<SubCategoryDetails> mockSubCategoryFiles = new ArrayList<>();
//		mockSubCategoryFiles.add(new SubCategoryDetails(1, "SubCategory 1", "Path1", null, null));
//		mockSubCategoryFiles.add(new SubCategoryDetails(2, "SubCategory 2", "Path2", null, null));
//
//		when(subCategoryRepository.findBySubCategoryID(anyInt()))
//				.thenReturn((ArrayList<SubCategoryDetails>) mockSubCategoryFiles);
//
//		// Assume KMFileManagerRepository would return an empty list for this example
//		when(kmFileManagerRepository.getKMFileLists(anyInt(), anyString())).thenReturn(new ArrayList<>());
//
//		// Call the method under test
//		List<SubCategoryDetails> result = commonService.getSubCategoryFiles(request);
//
//		// Assertions
//		assertNotNull(result, "The result should not be null");
//		assertEquals(2, result.size(), "Expected two items in the result");
//		assertEquals("SubCategory 1", result.get(0).getSubCategoryName(),
//				"The name of the first subcategory should match");
//		assertEquals("Path1", result.get(0).getSubCatFilePath(), "The path of the first subcategory should match");
//		assertEquals("SubCategory 2", result.get(1).getSubCategoryName(),
//				"The name of the second subcategory should match");
//		assertEquals("Path2", result.get(1).getSubCatFilePath(), "The path of the second subcategory should match");
//
//		// Verify repository interactions
//		verify(subCategoryRepository).findBySubCategoryID(1);
//		verify(kmFileManagerRepository, times(2)).getKMFileLists(anyInt(), anyString());
//	}

//	@Test
//	void testGetSubCategoryFilesWithURL() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCategoriesString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetActiveServiceTypes() {
//		fail("Not yet implemented");
//	}

}
