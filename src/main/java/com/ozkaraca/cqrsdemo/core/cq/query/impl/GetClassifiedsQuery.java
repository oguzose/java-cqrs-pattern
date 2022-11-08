package com.ozkaraca.cqrsdemo.core.cq.query.impl;

import com.ozkaraca.cqrsdemo.core.cq.query.Query;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GetClassifiedsQuery implements Query {

    private String price;

    private String categoryId;
}
