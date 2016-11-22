package com.WebAppES.posts.model;

import java.util.Map;

import org.elasticsearch.search.highlight.HighlightField;

public class PostBo {
	
	private String id;
	private String userName;
	private String postData;
	private Map<String,HighlightField> highlightMap;
	
	public Map<String, HighlightField> getHighlightMap() {
		return highlightMap;
	}
	public void setHighlightMap(Map<String, HighlightField> highlightMap) {
		this.highlightMap = highlightMap;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
