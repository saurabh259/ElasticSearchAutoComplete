package com.WebAppES.service;

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
@ContextConfiguration(locations = {"classpath:app-service.xml"})
public class ServiceTest {
	@BeforeClass
	public static void beforeClass() {
	
	} 

	@Resource
	private PostService ps;
	
	@Test
	public void searchPost()
	{
		try{
	
			
			List<PostBo> postbo =ps.searchPosts("3");
			
			for(PostBo post:postbo){
				System.out.println("User:"+post.getUserName()+"::Post:"+post.getPostData());
			}
		}
		
		catch(Exception e){
			System.out.println("Exception man!");
			e.printStackTrace();
		}
		
	}
	

}
