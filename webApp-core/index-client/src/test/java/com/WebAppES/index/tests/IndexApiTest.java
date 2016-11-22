package com.WebAppES.index.tests;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.WebAppES.index.dao.impl.IndexESDaoImpl;
import com.WebAppES.posts.model.PostBo;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-index.xml"})
public class IndexApiTest {
	@BeforeClass
	public static void beforeClass() {
	
	} 
	
	@Resource
	private IndexESDaoImpl indexDao;
	
	@Test
	public void addIndex()
	{
		String data = "So, so you think you can tell Heaven from Hell, blue skies from pain.\nCan you tell a green field from a cold steel rail?\nA smile from a veil?\nDo you think you can tell?\n\nDid they get you to trade your heroes for ghosts?\nHot ashes for trees?\nHot air for a cool breeze?\nCold comfort for change?\nDid you exchange a walk on part in the war for a lead role in a cage?\n\nHow I wish, how I wish you were here.\nWe're just two lost souls swimming in a fish bowl, year after year,\nRunning over the same old ground.\nWhat have we found?\nThe same old fears.\nWish you were here.";
		PostBo post = new PostBo();
		post.setId("002");
		post.setPostData(data);
		post.setUserName("Wish you were here");
			indexDao.addToIndex(post);
	}
	
	
	public void getAllData()
	{
		List<PostBo> postbo =indexDao.getAllPosts();
		
		for(PostBo post:postbo){
			System.out.println("User:"+post.getUserName()+"::Post:"+post.getPostData());
		}
	}
	
	
	public void searchPost()
	{
		List<PostBo> postbo =indexDao.searchPosts("3");
		
		for(PostBo post:postbo){
			System.out.println("User:"+post.getUserName()+"::Post:"+post.getPostData());
		}
		
	}
	

}
