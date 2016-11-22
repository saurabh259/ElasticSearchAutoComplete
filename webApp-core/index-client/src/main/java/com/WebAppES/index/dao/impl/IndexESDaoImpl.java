package com.WebAppES.index.dao.impl;



import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.highlight.HighlightField;
import org.springframework.stereotype.Repository;

import com.WebAppES.index.ESClient;
import com.WebAppES.index.IndexConstants;
import com.WebAppES.index.IndexDao;
import com.WebAppES.posts.model.IndexFields;
import com.WebAppES.posts.model.PostBo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class IndexESDaoImpl extends ESClient implements IndexDao {

	private static final ObjectMapper mapper = new ObjectMapper();
	@Override
	public void addToIndex(PostBo post) {
		
		Client client = getClient();
		
		try{
			IndexRequest indexRequest = new IndexRequest(
					IndexConstants.POST_INDEX_NAME,
					IndexConstants.POST_INDEX_TYPE)
					.source(mapper.writeValueAsString(post));
			
	        client.index(indexRequest).actionGet();

		} 
		
		catch(Exception e ) {
		 System.out.println("Error in indexing post"); 
		 }
				  
	}
	
	@Override
	public List<PostBo> getAllPosts() {
	
		Client client = getClient();
		
		SearchResponse response = client.prepareSearch(
				IndexConstants.POST_INDEX_NAME).setTypes(
				IndexConstants.POST_INDEX_TYPE).setSize(50).execute().actionGet();
		
		return parsePostSearchResponse(response);
	}
	
	@Override
	public List<PostBo> searchPosts(String keyword) {
		Client client = getClient();
		SearchRequestBuilder qb = client.prepareSearch(
				IndexConstants.POST_INDEX_NAME).setTypes(
						IndexConstants.POST_INDEX_TYPE)
				.addHighlightedField("postData",0,0).setHighlighterPreTags("<span style='color:red'>")
				.setHighlighterPostTags("</span>");
		
		MultiMatchQueryBuilder mmq = QueryBuilders.multiMatchQuery(keyword,IndexFields.POST_DATA,IndexFields.USERNAME);
		
		qb.setQuery(mmq);
		SearchResponse response = qb.execute().actionGet();
		return parsePostSearchResponse(response);
	}
	
	private List<PostBo> parsePostSearchResponse(SearchResponse response) {
		List<PostBo> postBos = new ArrayList<PostBo>();
		for (SearchHit hit : response.getHits()) {
			String sourceAsString = hit.getSourceAsString();
			Map<String,HighlightField> highlights = hit.getHighlightFields();
			try {
				PostBo post = mapper.readValue(sourceAsString,
						PostBo.class);
				post.setHighlightMap(highlights);
				postBos.add(post);
			} catch (IOException e) {
				System.out.println("Error in parsing post details from index");
			}
		}
		return postBos;
	}

}
