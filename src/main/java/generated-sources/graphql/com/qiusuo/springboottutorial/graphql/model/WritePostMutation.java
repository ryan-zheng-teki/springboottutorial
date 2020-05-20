package com.qiusuo.springbootcassandra.springbootcassandra.graphql.model;

public interface WritePostMutation {

    @javax.validation.constraints.NotNull
    PostTO writePost(String title, String text, String category) throws Exception;

}