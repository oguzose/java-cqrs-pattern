package com.ozkaraca.cqrsdemo.core.elastic.client;

import org.elasticsearch.client.RestHighLevelClient;

public interface ElasticsearchApiClient {

    RestHighLevelClient getRestHighLevelClient();

}
