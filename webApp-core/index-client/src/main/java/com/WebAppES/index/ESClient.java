
package com.WebAppES.index;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.inject.Injector;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.ImmutableBean;
import org.springframework.stereotype.Component;

@Component
public class ESClient {
	
	private Client client;
	
//	@Value("#{elasticsearchProperties['es.host.address']}")
//	private String host;
//
//	@Value("#{elasticsearchProperties['es.cluster.name']}")
//	private String clusterName;
//	
//	@Value("#{elasticsearchProperties['es.host.port']}")
//	private int port;
	
	@PostConstruct
	public void initialize(){
		Settings settings = ImmutableSettings.settingsBuilder()
		        .put("cluster.name", "posts").build();
//		        .put("client.transport.sniff", sniffClients).build();
		TransportClient transportClient = new TransportClient(settings);
			transportClient.addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
		client = transportClient;
	}
	
	public Client getClient(){
		return client;
	}
	
	@PreDestroy
	public void close(){
		client.close();
	}

}
