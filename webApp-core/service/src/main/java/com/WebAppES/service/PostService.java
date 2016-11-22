package com.WebAppES.service;

import java.util.List;

import com.WebAppES.posts.model.PostBo;

public interface PostService {
	
	void addPost(PostBo postBo);
	
	List<PostBo> listAllPosts();
	
	List<PostBo> searchPosts(String keyword);

}
