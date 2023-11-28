package com.iemr.common.service.beneficiary;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.iemr.common.data.eausadha.ItemMaster;
import com.iemr.common.data.eausadha.ItemStockEntry;
import com.iemr.common.data.facility.Facility;
import com.iemr.common.model.eAusadha.EAusadhaDTO;
import com.iemr.common.repository.eausadha.ItemMasterRepo;
import com.iemr.common.repository.eausadha.ItemStockEntryRepo;
import com.iemr.common.repository.facility.FacilityRepo;

@Service
public class EAusadhaServiceImpl implements EAusadhaService {

	@Autowired
	private FacilityRepo facilityRepo;
	@Autowired
	private ItemMasterRepo itemMasterRepo;
	@Autowired
	private ItemStockEntryRepo itemStockEntryRepo;

	@Value("${eAusadhaUrl}")
	private String eAusadhaUrl;

	@Value("${authorization}")
	private String authorization;

	@Override
	public String createEAusadha(EAusadhaDTO eAusadhaDTO, String Authorization) throws Exception {
		List<Map<String, String>> failedStockList = new ArrayList<>();
		String drugId = null;
		String batchNumber = null;
		String drugName = null;
		Integer lengthOfArray = null;
		Integer successCount = null;
		String inwardDate=null;

		Map<String, String> resMap = new HashMap<>();
		Map<String, String> resultMap = new HashMap<>();
		Map<String, Object> resultSet = new HashMap<>();
		Map<String, Object> responseMap = new HashMap<>();

		Integer institutionId = facilityRepo.fetchInstitutionId(eAusadhaDTO.getFacilityId());
		if(eAusadhaDTO.getInwardDate() != null) {
			LocalDateTime localDateTime = eAusadhaDTO.getInwardDate().toLocalDateTime();
			SimpleDateFormat inwardDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			inwardDate = inwardDateFormat.format(eAusadhaDTO.getInwardDate());
			
		}

		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8");
		headers.add("AUTHORIZATION", authorization);
		// create a map to hold both inwardDate and institutionId
		Map<String, Object> request = new HashMap<>();
		request.put("InwardDate", inwardDate);
		request.put("InstituteId", institutionId);

		HttpEntity<Map<String, Object>> requestObj = new HttpEntity<>(request, headers);

		ResponseEntity<String> response = restTemplate.exchange(eAusadhaUrl, HttpMethod.POST, requestObj, String.class);

		if (response.getStatusCode() == HttpStatus.OK && response.hasBody()) {
			String responseStr = response.getBody();
			JSONArray responseArray = new JSONArray(responseStr);
			lengthOfArray = responseArray.length();

			for (Object obj : responseArray) {
				JSONObject responseOBJ = new JSONObject(obj);
				drugId = responseOBJ.getJSONObject("data").getString("Drug_id");
				batchNumber = responseOBJ.getJSONObject("data").getString("Batch_number");
				drugName = responseOBJ.getJSONObject("data").getString("Drug_name");

				ItemMaster itemCode = itemMasterRepo.findByItemCode(drugId);
				if (itemCode != null && null != itemCode.getItemID()) {
					Integer itemId = itemCode.getItemID();
					ItemStockEntry itemStock = itemStockEntryRepo.findByItemIDAndBatchNo(itemId, batchNumber);
					if (itemStock == null && ObjectUtils.isEmpty(itemStock)) {
						saveItemStockEntry(responseOBJ);
					}
				} else {
		//			listOfDrugIds.add(drugName);
					Map<String, String> failedStockItem = new HashMap<>();
					failedStockItem.put("DrugName", drugName);
					failedStockItem.put("BatchNo", batchNumber);
					failedStockList.add(failedStockItem);
				}

			}
			if (lengthOfArray == successCount) {
		//		resultMap.put("response", "Stock entered Successfully");
			} else {
				resultMap.put("response", "Stock entered Successfully");
				resultSet.put("failedStocks", failedStockList);
				responseMap.put("data", resultMap);
				responseMap.put("failedStocks", new Gson().toJson(resultSet.get("failedStocks")));
			}

		}
		return new Gson().toJson(responseMap);

	}

	private void saveItemStockEntry(JSONObject responseOBJ) {
		ItemStockEntry newItem = new ItemStockEntry();
		JSONObject jsonObject = responseOBJ.getJSONObject("data");
		newItem.setFacilityID(jsonObject.getInt("instituteid"));
		newItem.setItemID(jsonObject.getInt("Drug_id"));
		newItem.setBatchNo(jsonObject.getString("Batch_number"));
		newItem.setQuantityInHand(jsonObject.getInt("Quantity_In_Units"));
		Date date = new Date(jsonObject.getString("Exp_date"));
		newItem.setExpiryDate(date);
		itemStockEntryRepo.save(newItem);
	}

}
