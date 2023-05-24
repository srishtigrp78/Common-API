package com.iemr.common.repository.mctshistory;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.mctshistory.MctsDataReaderDetail;
import com.iemr.common.data.mctshistory.MctsOutboundCall;
import com.iemr.common.data.mctshistory.MctsOutboundCallDetail;

@Repository
@RestResource(exported = false)
public interface OutboundHistoryRepository extends CrudRepository<MctsOutboundCallDetail, Long> {

	@Query("select cd from MctsOutboundCallDetail cd join cd.callType where cd.beneficiaryRegID = :beneficiaryRegID "
			+ "and (cd.isMother =1 or cd.isMother =0) "
			+ " order by cd.createdDate desc ")
	public ArrayList<MctsOutboundCallDetail> getCallHistory(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query("select cd from MctsOutboundCallDetail cd where cd.beneficiaryRegID = :beneficiaryRegID "
			+ "and cd.isMother !=null ")
	public ArrayList<MctsOutboundCallDetail> checkBenExist(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	
	@Transactional
	@Modifying
	@Query("update MctsDataReaderDetail mothetData set mothetData.Name = :Name, mothetData.Age = :Age, "
			+ "mothetData.District_Name = :District_Name, mothetData.Taluka_Name = :Taluka_Name, mothetData.Village_Name = :Village_Name, "
			+ "mothetData.LastModDate = :LastModDate "
			+ " where mothetData.BeneficiaryRegID = :BeneficiaryRegID ")
	public int updateMotherData(@Param("Name") String Name, @Param("Age") Integer Age, @Param("District_Name") String District_Name, @Param("Taluka_Name") String Taluka_Name,
			@Param("Village_Name") String Village_Name, @Param("LastModDate") Timestamp LastModDate,
			@Param("BeneficiaryRegID") Long BeneficiaryRegID);
	
	@Transactional
	@Modifying
	@Query("update ChildValidDataHandler childData set childData.Child_Name = :Child_Name, childData.Gender = :Gender, "
			+ "childData.District_Name = :District_Name, childData.Taluka_Name = :Taluka_Name, childData.Village_Name = :Village_Name, "
			+ "childData.LastModDate = :LastModDate "
			+ " where childData.BeneficiaryRegID = :BeneficiaryRegID ")
	public int updateChildData(@Param("Child_Name") String Child_Name, @Param("Gender") String Gender, @Param("District_Name") String District_Name, @Param("Taluka_Name") String Taluka_Name,
			@Param("Village_Name") String Village_Name, @Param("LastModDate") Timestamp LastModDate,
			@Param("BeneficiaryRegID") Long BeneficiaryRegID);
	
	/**
	 * query method to get district
	 * @param districtID
	 * @return
	 */
	@Query("select district.districtName from Districts district where district.districtID = :districtID and district.deleted = 0 ")
	public String getDistrictName(@Param("districtID") Integer districtID);
	
	/**
	 * query method to get block
	 * @param blockID
	 * @return
	 */
	@Query("select districtBlock.blockName from DistrictBlock districtBlock where districtBlock.blockID = :blockID and districtBlock.deleted = 0 ")
	public String getBlockName(@Param("blockID") Integer blockID);
	
	/**
	 * query method to get Village
	 * @param districtBranchID
	 * @return
	 */
	@Query("select village.villageName from DistrictBranchMapping village where village.districtBranchID = :districtBranchID and village.deleted = 0 ")
	public String getVillageName(@Param("districtBranchID") Integer districtBranchID);
	
	/**
	 * query method to get MCTS Call Start Date
	 * @param obCallID
	 * @return
	 */
	@Query("select mctscalls from MctsOutboundCall mctscalls "
			+ "where mctscalls.obCallID =:obCallID ")
	public MctsOutboundCall getMCTSCallStartDate(@Param("obCallID") Long obCallID);
	
	/**
	 * query method to get MCTS Record
	 * @param MCTSID_no
	 * @return
	 */
	@Query("select mctsDataReaderDetail from MctsDataReaderDetail mctsDataReaderDetail "
			+ "where mctsDataReaderDetail.MCTSID_no =:MCTSID_no ")
	public MctsDataReaderDetail getMCTSRecord(@Param("MCTSID_no") Long MCTSID_no);
}
