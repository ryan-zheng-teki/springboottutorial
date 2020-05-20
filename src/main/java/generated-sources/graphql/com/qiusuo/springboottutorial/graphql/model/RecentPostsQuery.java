package com.qiusuo.springbootcassandra.springbootcassandra.graphql.model;

import java.util.*;

public interface RecentPostsQuery {

    @javax.validation.constraints.NotNull
    Collection<PostTO> recentPosts(Integer count, Integer offset) throws Exception;

}