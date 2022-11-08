package com.ozkaraca.cqrsdemo.core.cq.query.impl;

import com.ozkaraca.cqrsdemo.core.cq.query.QueryHandler;
import com.ozkaraca.cqrsdemo.core.elastic.service.ElasticsearchService;
import com.ozkaraca.cqrsdemo.entity.Classified;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetClassifiedsQueryHandler implements QueryHandler<GetClassifiedsQuery, List<Classified>> {

    private final ElasticsearchService elasticsearchService;

    @Autowired
    public GetClassifiedsQueryHandler(ElasticsearchService elasticsearchService) {
        this.elasticsearchService = elasticsearchService;
    }

    @Override
    public List<Classified> handle(GetClassifiedsQuery query) throws Exception {
        return this.elasticsearchService.search("classifieds", Classified.class);
    }
}
