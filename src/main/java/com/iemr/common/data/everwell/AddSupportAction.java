package com.iemr.common.data.everwell;

import java.sql.Timestamp;

public class AddSupportAction {
private String Category;
private String ActionTaken;
private String Comments;
private String SubCategory;
private Timestamp DateOfAction;
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
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
public String getSubCategory() {
	return SubCategory;
}
public void setSubCategory(String subCategory) {
	SubCategory = subCategory;
}
public Timestamp getDateOfAction() {
	return DateOfAction;
}
public void setDateOfAction(Timestamp dateOfAction) {
	DateOfAction = dateOfAction;
}

}
