package com.WebAppES.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebAppES.index.IndexDao;
import com.WebAppES.posts.model.PostBo;
import com.WebAppES.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private IndexDao indexDao;

	@Override
	public void addPost(PostBo post) {
		indexDao.addToIndex(post);
	}

	@Override
	public List<PostBo> listAllPosts() {
		return indexDao.getAllPosts();
	}

	@Override
	public List<PostBo> searchPosts(String keyword) {
		return indexDao.searchPosts(keyword);
	}
	
	
	
	
	
	

}
