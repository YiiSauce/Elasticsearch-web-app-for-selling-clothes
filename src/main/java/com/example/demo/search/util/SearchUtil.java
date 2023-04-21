package com.example.demo.search.util;

import com.example.demo.search.SearchRequestDTO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.util.CollectionUtils;

import java.util.List;

public final class SearchUtil {
    public SearchUtil(){}

    public static SearchRequest buildSearchRequest(final String indexName, final SearchRequestDTO dto){
        try {
            SearchSourceBuilder builder = new SearchSourceBuilder().postFilter(getQueryBuilder(dto));
            SearchRequest request = new SearchRequest(indexName);
            request.source(builder);
            return request;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static QueryBuilder getQueryBuilder(SearchRequestDTO dto){
        if(dto == null)
            return null;

        final List<String> fields=dto.getFields();
        if(CollectionUtils.isEmpty(fields))
            return null;
        if(fields.size()>1){
            MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(dto.getSearchTerm())
                    .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).operator(Operator.OR);
            fields.forEach(queryBuilder::field);
            return queryBuilder;
        }
        return fields.stream().findFirst().map(field ->QueryBuilders.matchQuery(field, dto.getSearchTerm())
                .operator(Operator.OR))
                .orElse(null);
    }

}
