package com.iemr.common.repository.callhandling;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.callhandling.CallType;

@Repository
@RestResource(exported = false)
public interface IEMRCalltypeRepositoryImplCustom extends CrudRepository<CallType, Long>
{

	@Query("select callType, callTypeID, callTypeDesc, callGroupType, fitToBlock, fitForFollowUp from CallType "
			+ "where deleted=false order by callType asc")
	Iterable<CallType> readData();

	// @Transactional
	// @Modifying(clearAutomatically = true)
	// @Query("UPDATE CallType c set c.remarks =:remarks, c.callType =:callType
	// where c.id = :id")
	// int updateCallType(@Param("id") Long id,@Param("callType") String
	// callType, @Param("remarks") String remarks);

	/*
	 * @Query("UPDATE CallType c set c.remarks =:"+m_Calltype.getId()+
	 * ", c.callType =:m_Calltype.getId() where c.id = :m_Calltype.getId()") int updateCallType(CallType m_Calltype);
	 */

	@Query("select callType, callTypeID, callTypeDesc, callGroupType, fitToBlock, fitForFollowUp, "
			+ "isInbound, isOutbound from CallType "
			+ "where deleted=false and providerServiceMapID = :providerServiceMapID order by callType asc")
	Set<Objects[]> getCallTypes(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select callType, callTypeID, callTypeDesc, callGroupType, fitToBlock, fitForFollowUp, "
			+ "isInbound, isOutbound from CallType "
			+ "where deleted=false and providerServiceMapID = :providerServiceMapID and "
			+ "(isInbound is null or isInbound = :isInbound )and "
			+ "(isOutbound is null or isOutbound = :isOutbound) order by callType asc")
	Set<Objects[]> getCallTypes(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("isInbound") Boolean isInbound, @Param("isOutbound") Boolean isOutbound);

	@Query("select callType, callTypeID, callTypeDesc, callGroupType, fitToBlock, fitForFollowUp, "
			+ "isInbound, isOutbound from CallType "
			+ "where deleted=false and providerServiceMapID = :providerServiceMapID and "
			+ "(isInbound is null or isInbound = :isInbound ) order by callType asc")
	Set<Objects[]> getInboundCallTypes(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("isInbound") Boolean isInbound);

	@Query("select callType, callTypeID, callTypeDesc, callGroupType, fitToBlock, fitForFollowUp, "
			+ "isInbound, isOutbound from CallType "
			+ "where deleted=false and providerServiceMapID = :providerServiceMapID and "
			+ "(isOutbound is null or isOutbound = :isOutbound) order by callType asc")
	Set<Objects[]> getOutboundCallTypes(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("isOutbound") Boolean isOutbound);

	@Query("select maxRedial from CallType where callTypeID = :callTypeID")
	Integer getMaxRedialByCallTypeID(@Param("callTypeID") Integer callTypeID);

	@Query("select callType from CallType callType where deleted = false and fitToBlock = true")
	List<CallType> getFitToBlockCallTypes();
	
	@Query("select callType from CallType callType where deleted = false and callTypeID = :callTypeID")
	CallType getCallTypeDetails(@Param("callTypeID") Integer callTypeID);
	
	
}
