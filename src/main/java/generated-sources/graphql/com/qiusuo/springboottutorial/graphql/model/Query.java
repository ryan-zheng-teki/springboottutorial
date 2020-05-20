package com.qiusuo.springbootcassandra.springbootcassandra.graphql.model;

import java.util.*;

public interface Query {

    @javax.validation.constraints.NotNull
    Collection<PostTO> recentPosts(Integer count, Integer offset) throws Exception;

}