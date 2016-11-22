package com.WebAppES.dto;

import java.util.List;

import com.WebAppES.posts.model.PostBo;

import io.swagger.annotations.ApiModelProperty;

public class PostListingResponse {
	
	@ApiModelProperty(value="the list of all posts")
	private List<PostBo> postList;

	public List<PostBo> getPostList() {
		return postList;
	}

	public void setPostList(List<PostBo> postList) {
		this.postList = postList;
	}

}
