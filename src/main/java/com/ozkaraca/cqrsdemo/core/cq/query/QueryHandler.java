package com.ozkaraca.cqrsdemo.core.cq.query;

public interface QueryHandler<TQuery extends Query, TResult> {

    TResult handle(TQuery query) throws Exception;

}
