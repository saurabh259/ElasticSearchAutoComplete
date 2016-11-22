package com.WebAppES.dto;

import io.swagger.annotations.ApiModelProperty;

public class PostRequest {
	
	@ApiModelProperty(value="postId", required=true)
	private String postId;
	
	@ApiModelProperty(value="Username", required=true)
	private String userName;
	
	@ApiModelProperty(value="PostData", required=true)
	private String postData;

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}
	
	
	
	

}
