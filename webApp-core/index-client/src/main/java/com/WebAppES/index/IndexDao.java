package com.WebAppES.index;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.WebAppES.posts.model.PostBo;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface IndexDao {

		//Indexes Data 
		void addToIndex(PostBo post);   
		
		//Fetch Data
		List<PostBo> getAllPosts();
		
		//Search Post
		List<PostBo> searchPosts(String keyword);
		
		
	
}
