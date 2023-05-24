package com.iemr.common.data.everwell;
import java.sql.Timestamp;
public class Note {
	private Integer UserId;
	private String UserDescription;
	private String ActionTaken;
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUserDescription() {
		return UserDescription;
	}
	public void setUserDescription(String userDescription) {
		UserDescription = userDescription;
	}
	public String getActionTaken() {
		return ActionTaken;
	}
	public void setActionTaken(String actionTaken) {
		ActionTaken = actionTaken;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getSubCategory() {
		return SubCategory;
	}
	public void setSubCategory(String subCategory) {
		SubCategory = subCategory;
	}
	public Timestamp getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		Timestamp = timestamp;
	}
	public Timestamp getDateOfAction() {
		return DateOfAction;
	}
	public void setDateOfAction(Timestamp dateOfAction) {
		DateOfAction = dateOfAction;
	}
	private String Comments;
	private String Category;
	private String SubCategory;
	private Timestamp Timestamp;
	private Timestamp DateOfAction;

}
